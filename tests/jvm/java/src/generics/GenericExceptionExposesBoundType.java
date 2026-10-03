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

package generics;

import org.mases.jcobridge.netreflection.*;

import system.*;
import system.collections.generic.*;
import system.collections.objectmodel.*;

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented. They are written as plain static methods on purpose,
 * so they can be dropped into whatever test harness the project actually uses (JUnit, plain
 * {@code main}, or something else) without depending on a particular framework.
 * <p>
 */
public class GenericExceptionExposesBoundType {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericExceptionExposesBoundType();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises the exception-specific fallback: a generic .NET exception (e.g.
     * FaultException<TDetail>) can never become a generic Java class (a generic class cannot
     * extend Throwable), so its class-level type parameter is always exposed as its bound,
     * IJCOBridgeReflected, rather than as a real type variable.
     */
    static void testGenericExceptionExposesBoundType() throws Throwable {
        Class<?> ex;
        try {
            ex = Class.forName("system.servicemodel.FaultException_1", false,
                    GenericExceptionExposesBoundType.class.getClassLoader());
        } catch (ClassNotFoundException notAvailable) {
            Console.WriteLine("FaultException_1 not available in this framework, skipping");
            return;
        }
        // A generic Java class can't extend Throwable, so it must be plain, non-generic...
        if (ex.getTypeParameters().length != 0) throw new AssertionError("FaultException_1 must not be generic");
        // ...and its class-level type parameter is exposed as the bound.
        if (ex.getMethod("getDetail").getReturnType() != IJCOBridgeReflected.class)
            throw new AssertionError("getDetail() must return IJCOBridgeReflected");
    }
}
