/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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

package org.mases.jcobridge.netreflection;

import org.mases.jcobridge.JCRefOut;

public class JCORefOut<T> {
    T mrefObj = null;
    T[] mrefArray = null;

    JCORefOut(T refObj) {
        mrefObj = refObj;
    }

    JCORefOut(T[] refObj) {
        mrefArray = refObj;
    }

    /**
     * Initialize a new {@link JCORefOut} using the Object.
     * 
     * @param refObj The referenced object: it can be native array (byte[], int[],
     *               and so on), {@link AtomicReference}, {@link AtomicBoolean},
     *               {@link AtomicInteger}, {@link AtomicLong},
     *               {@link AtomicIntegerArray}, {@link AtomicLongArray}
     * @param <T>    Type to use
     * @return the new {@link JCORefOut}
     */
    public static <T> JCORefOut<T> Create(T refObj) {
        return new JCORefOut<T>(refObj);
    }

    /**
     * Initialize a new {@link JCORefOut} using the Object.
     * 
     * @param refObj The referenced object: it can be native array (byte[], int[],
     *               and so on), {@link AtomicReference}, {@link AtomicBoolean},
     *               {@link AtomicInteger}, {@link AtomicLong},
     *               {@link AtomicIntegerArray}, {@link AtomicLongArray}
     * @param <T>    Type to use
     * @return the new {@link JCORefOut}
     */
    public static <T> JCORefOut<T> Create(T[] refObj) {
        return new JCORefOut<T>(refObj);
    }

    /**
     * Returns an instance of {@link JCRefOut} to be passed to the underlying layer
     * 
     * @return an instance of {@link JCRefOut}
     */
    public Object getJCRefOut() {
        if (mrefObj != null) {
            return JCRefOut.Create((T)mrefObj);
        } else {
            return JCRefOut.Create((T[])mrefArray);
        }
    }
}
