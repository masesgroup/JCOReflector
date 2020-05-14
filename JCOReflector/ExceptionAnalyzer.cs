/*
 * 
 * Code based on https://stackoverflow.com/questions/986180/how-can-i-determine-which-exceptions-can-be-thrown-by-a-given-method
 * 
 * ILReader from https://docs.microsoft.com/en-us/archive/blogs/haibo_luo/
 * 
 */

using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reflection;
using System.Reflection.Emit;
using System.Text;
using ClrTest.Reflection;

public static class ExceptionAnalyser
{
    public static ReadOnlyCollection<Type> GetAllExceptions(this MethodBase method, int maxDepth = -1)
    {
        var exceptionTypes = new HashSet<Type>();
        var visitedMethods = new HashSet<MethodBase>();
        var localVars = new Type[ushort.MaxValue];
        var stack = new Stack<Type>();
        GetAllExceptions(method, exceptionTypes, visitedMethods, localVars, stack, 0, maxDepth);

        return exceptionTypes.ToList().AsReadOnly();
    }

    public static void GetAllExceptions(MethodBase method, HashSet<Type> exceptionTypes,
        HashSet<MethodBase> visitedMethods, Type[] localVars, Stack<Type> stack, int depth, int maxDepth = -1)
    {
        if (depth == maxDepth) return;
        var ilReader = new ILReader(method);
        var allInstructions = ilReader.ToArray();

        ILInstruction instruction;
        for (int i = 0; i < allInstructions.Length; i++)
        {
            instruction = allInstructions[i];

            if (instruction is InlineMethodInstruction)
            {
                var methodInstruction = (InlineMethodInstruction)instruction;

                if (!visitedMethods.Contains(methodInstruction.Method))
                {
                    visitedMethods.Add(methodInstruction.Method);
                    GetAllExceptions(methodInstruction.Method, exceptionTypes, visitedMethods,
                        localVars, stack, depth + 1, maxDepth);
                }

                var curMethod = methodInstruction.Method;
                if (curMethod is ConstructorInfo)
                    stack.Push(((ConstructorInfo)curMethod).DeclaringType);
                else if (method is MethodInfo)
                    stack.Push(((MethodInfo)curMethod).ReturnParameter.ParameterType);
            }
            else if (instruction is InlineFieldInstruction)
            {
                var fieldInstruction = (InlineFieldInstruction)instruction;
                stack.Push(fieldInstruction.Field.FieldType);
            }
            else if (instruction is ShortInlineBrTargetInstruction)
            {
            }
            else if (instruction is InlineBrTargetInstruction)
            {
            }
            else
            {
                switch (instruction.OpCode.Value)
                {
                    // ld*
                    case 0x06:
                        stack.Push(localVars[0]);
                        break;
                    case 0x07:
                        stack.Push(localVars[1]);
                        break;
                    case 0x08:
                        stack.Push(localVars[2]);
                        break;
                    case 0x09:
                        stack.Push(localVars[3]);
                        break;
                    case 0x11:
                        {
                            var index = (ushort)allInstructions[i + 1].OpCode.Value;
                            stack.Push(localVars[index]);
                            break;
                        }
                    // st*
                    case 0x0A:
                        localVars[0] = stack.Pop();
                        break;
                    case 0x0B:
                        localVars[1] = stack.Pop();
                        break;
                    case 0x0C:
                        localVars[2] = stack.Pop();
                        break;
                    case 0x0D:
                        localVars[3] = stack.Pop();
                        break;
                    case 0x13:
                        {
                            var index = (ushort)allInstructions[i + 1].OpCode.Value;
                            localVars[index] = stack.Pop();
                            break;
                        }
                    // throw
                    case 0x7A:
                        if (stack.Peek() == null)
                            break;
                        if (!typeof(Exception).IsAssignableFrom(stack.Peek()))
                        {
                            //var ops = allInstructions.Select(f => f.OpCode).ToArray();
                            //break;
                        }
                        exceptionTypes.Add(stack.Pop());
                        break;
                    default:
                        switch (instruction.OpCode.StackBehaviourPop)
                        {
                            case StackBehaviour.Pop0:
                                break;
                            case StackBehaviour.Pop1:
                            case StackBehaviour.Popi:
                            case StackBehaviour.Popref:
                            case StackBehaviour.Varpop:
                                stack.Pop();
                                break;
                            case StackBehaviour.Pop1_pop1:
                            case StackBehaviour.Popi_pop1:
                            case StackBehaviour.Popi_popi:
                            case StackBehaviour.Popi_popi8:
                            case StackBehaviour.Popi_popr4:
                            case StackBehaviour.Popi_popr8:
                            case StackBehaviour.Popref_pop1:
                            case StackBehaviour.Popref_popi:
                                stack.Pop();
                                stack.Pop();
                                break;
                            case StackBehaviour.Popref_popi_pop1:
                            case StackBehaviour.Popref_popi_popi:
                            case StackBehaviour.Popref_popi_popi8:
                            case StackBehaviour.Popref_popi_popr4:
                            case StackBehaviour.Popref_popi_popr8:
                            case StackBehaviour.Popref_popi_popref:
                                stack.Pop();
                                stack.Pop();
                                stack.Pop();
                                break;
                        }

                        switch (instruction.OpCode.StackBehaviourPush)
                        {
                            case StackBehaviour.Push0:
                                break;
                            case StackBehaviour.Push1:
                            case StackBehaviour.Pushi:
                            case StackBehaviour.Pushi8:
                            case StackBehaviour.Pushr4:
                            case StackBehaviour.Pushr8:
                            case StackBehaviour.Pushref:
                            case StackBehaviour.Varpush:
                                stack.Push(null);
                                break;
                            case StackBehaviour.Push1_push1:
                                stack.Push(null);
                                stack.Push(null);
                                break;
                        }

                        break;
                }
            }
        }
    }
}