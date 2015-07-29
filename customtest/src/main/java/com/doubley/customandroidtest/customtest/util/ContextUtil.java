package com.doubley.customandroidtest.customtest.util;

import android.content.Context;
import android.test.AndroidTestCase;

import java.lang.reflect.Method;

/**
 * Created by yasudayousuke on 7/29/15.
 */
public class ContextUtil {
    public static Context getTestContext(AndroidTestCase testCase) {
        @SuppressWarnings("unchecked")
        Class clz = testCase.getClass();
        Method method;
        try {
            method = clz.getMethod("getTestContext");
            return (Context) method.invoke(testCase);
        } catch (Exception e) {
            return null;
        }
    }
}
