/*
 *  MIT License
 *
 *  Copyright (c) 2020-2026 MASES s.r.l.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace MASES.JCOReflector.Engine
{
    static partial class Reflector
    {
        static bool IsNewEvent(this Type type, EventInfo eventInfo, IList<EventInfo> allEvents)
        {
            MethodInfo method = eventInfo.AddMethod;
            string refSign = eventInfo.AddMethod.SignatureWithoutRetVal();
            if (method.GetBaseDefinition().DeclaringType == type)
            {
                foreach (var item in allEvents)
                {
                    if (item.Name == eventInfo.Name
                        && item.DeclaringType != type
                        && item.AddMethod.SignatureWithoutRetVal() == refSign)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        static void SearchEvents(this Type type, BindingFlags flags, IList<EventInfo> allEvents, bool traverseHierarchy)
        {
            foreach (var item in type.GetEvents(flags))
            {
                allEvents.Add(item);
            }

            if (traverseHierarchy)
            {
                foreach (var item in type.GetInterfaces())
                {
                    if (!item.IsManagedType(0, 1)) continue;
                    item.SearchEvents(flags, allEvents, traverseHierarchy);
                }
            }
            else if (type.BaseType != null)
            {
                if (!type.BaseType.IsManagedType(0, 1) || type.BaseType == typeof(object) || type.BaseType == typeof(Exception) || type.BaseType == typeof(Type)) return;
                type.BaseType.SearchEvents(flags, allEvents, traverseHierarchy);
            }
        }

        static string ExportEvents(this Type type, IList<Type> imports, IList<Type> implementableInterfaces, bool withInheritance, bool statics, bool isException, string destFolder, string assemblyname, out string returnInterfaceSection)
        {
            bool isInterface = false;
            returnInterfaceSection = string.Empty;

            BindingFlags flags = BindingFlags.Public;
            flags |= statics ? BindingFlags.Static : BindingFlags.Instance;

            EventInfo[] events = null;

            List<EventInfo> allEvents = new List<EventInfo>();

            if (type.IsInterface)
            {
                isInterface = true;
            }
            type.SearchEvents(flags, allEvents, isInterface);
            events = allEvents.ToArray();

            if (events.Length == 0) return string.Empty;

            SortedDictionary<string, EventInfo> sortedData = new SortedDictionary<string, EventInfo>();
            foreach (var item in events)
            {
                var strMethod = item.ToString();
                if (!sortedData.ContainsKey(strMethod))
                {
                    sortedData.Add(strMethod, item);
                }
            }

            var eventLst = new List<EventInfo>();
            eventLst.AddRange(sortedData.Values);

            events = eventLst.ToArray();

            string templateInterfaceToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceEventTemplate);
            string templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassEventTemplate);

            StringBuilder eventInterfaceBuilder = new StringBuilder();
            StringBuilder eventBuilder = new StringBuilder();
            eventBuilder.AppendLine();
            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isConcrete = true;
            bool isSpecial = false;
            bool isArray = false;

            List<string> eventsSignaturesCreated = new List<string>();
            List<string> eventsNameCreated = new List<string>();

            foreach (var item in events)
            {
                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref analyzedEvents);
                    }
                }
                else
                {
                    Interlocked.Increment(ref analyzedEvents);
                }

                var eventName = item.Name;

                isPrimitive = true;
                defaultPrimitiveValue = string.Empty;
                isConcrete = true;
                isSpecial = false;
                isArray = false;

                if (isException)
                {
                    if (eventName == "Message") continue;
                    if (eventName == "StackTrace") continue;
                }

                if (eventsSignaturesCreated.Contains(item.ToString())
                    || item.IsSpecialName
                    || ((withInheritance && !isInterface) ? item.DeclaringType != type : false)
                    || (!eventsNameCreated.Contains(eventName) ? false : eventsSignaturesCreated.IsDifferentOnlyForRetVal(item.ToString(), eventName))
                   ) continue;

                string eventType = "void";
                StringBuilder inputParams = new StringBuilder();
                StringBuilder execParams = new StringBuilder();

                // FIXED PIPELINE CHANNELS: Added required out string parameter to match updated ExportingDelegate signature
                string dummyEnumeratorType = string.Empty;
                // A handler that is a constructed generic delegate, open over in-scope type parameters (Progress<T>.ProgressChanged is
                // EventHandler<T>) or closed (AppDomain.FirstChanceException is EventHandler<FirstChanceExceptionEventArgs>), is
                // checked and exported through its generic definition, and registered with its type arguments.
                bool isHandlerConstructedGeneric = !isException && IsResolvableConstructedGeneric(item.EventHandlerType, true)
                                                   && !DeclaresSameEventInBaseClass(type, eventName);
                var handlerToExport = isHandlerConstructedGeneric ? item.EventHandlerType.GetGenericTypeDefinition() : item.EventHandlerType;
                if (!handlerToExport.ExportingDelegate(destFolder, assemblyname, out dummyEnumeratorType, true)) continue;

                eventType = ConvertType(imports, item.EventHandlerType, out isPrimitive, out defaultPrimitiveValue, out isConcrete, out isSpecial, out isArray);
                if (!isConcrete) continue; // found not managed type, jump to next 

                bool isNewEventVal = (withInheritance && !isInterface) ? type.IsNewEvent(item, eventLst) : false;
                string newEventName = string.Empty;
                if (isNewEventVal)
                {
                    newEventName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, eventName, type.GetJavaClassName(type.Assembly));
                }

                // RESOLUTION GENERICS: Resolve non-colliding java name for the handler delegate type
                string javaHandlerName = isHandlerConstructedGeneric
                    ? ResolveGenericTypeName(item.EventHandlerType, imports)
                    : item.EventHandlerType.GetJavaClassName(item.EventHandlerType.Assembly);

                var eventStr = templateToUse.Replace(Const.Events.EVENT_JAVA_NAME, isNewEventVal ? newEventName : eventName)
                                            .Replace(Const.Events.EVENT_NAME, eventName)
                                            .Replace(Const.Events.EVENT_HANDLER_TYPE, javaHandlerName)
                                            .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, statics ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                            .Replace(Const.Events.EVENT_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

                eventsSignaturesCreated.Add(item.ToString());
                eventsNameCreated.Add(item.Name);

                if (withInheritance ? (isInterface && (item.AddMethod.GetBaseDefinition().DeclaringType == type)) : isInterface)
                {
                    var eventInterfaceStr = templateInterfaceToUse.Replace(Const.Events.EVENT_JAVA_NAME, isNewEventVal ? newEventName : eventName)
                                                                  .Replace(Const.Events.EVENT_NAME, eventName)
                                                                  .Replace(Const.Events.EVENT_HANDLER_TYPE, javaHandlerName)
                                                                  .Replace(Const.Events.METHOD_MODIFIER_KEYWORD, statics ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                                                  .Replace(Const.Events.EVENT_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

                    eventInterfaceBuilder.AppendLine(eventInterfaceStr);
                }

                eventBuilder.AppendLine(eventStr);

                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref implementedEvents);
                    }
                }
                else
                {
                    Interlocked.Increment(ref implementedEvents);
                }
            }

            if (isInterface) returnInterfaceSection = eventInterfaceBuilder.ToString();

            return eventBuilder.ToString();
        }
    }
}
