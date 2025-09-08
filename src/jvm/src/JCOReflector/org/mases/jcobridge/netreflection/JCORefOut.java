/*
 *  MIT License
 *
 *  Copyright (c) 2020-2025 MASES s.r.l.
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

import java.util.ArrayList;
import java.util.concurrent.atomic.*;

/**
 * Wrapper class around {@link JCRefOut}
 */
public class JCORefOut<T> {
	JCRefOut mJCRefOut = null;
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
    public Object getJCRefOut() throws Throwable {
        if (mrefObj != null) {
            if (mrefObj instanceof IJCOBridgeReflected) {
                IJCOBridgeReflected o = (IJCOBridgeReflected) mrefObj;
                mJCRefOut = JCRefOut.Create(o.getJCOInstance(), this);
            } else
                mJCRefOut = JCRefOut.Create((T) mrefObj, this);
        } else {
            if (mrefArray != null && mrefArray.length > 0 && mrefArray[0] instanceof IJCOBridgeReflected) {
                ArrayList<Object> retValJCArrayList = new ArrayList<Object>();
                for (int index = 0; index < mrefArray.length; index++) {
                    IJCOBridgeReflected o = (IJCOBridgeReflected) mrefArray[index];
                    retValJCArrayList.add(o.getJCOInstance());
                }
				Object[] newArray = retValJCArrayList.toArray();
                mJCRefOut = JCRefOut.Create(newArray, new Object[] { this, newArray } );
            } else
                mJCRefOut = JCRefOut.Create((T[]) mrefArray, this);
        }
		return mJCRefOut;
    }
}
