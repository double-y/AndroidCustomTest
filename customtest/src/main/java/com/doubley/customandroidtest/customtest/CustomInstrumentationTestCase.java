package com.doubley.customandroidtest.customtest;

import android.content.res.AssetManager;
import android.test.InstrumentationTestCase;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * Created by yasudayousuke on 7/2/15.
 */
public class CustomInstrumentationTestCase extends InstrumentationTestCase {

    protected String getStringFromAssetFile(String filename) throws IOException {
        AssetManager assets = getInstrumentation().getContext().getAssets();
        String buffer = "";

        InputStream is = assets.open(filename);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String str;
        while((str = reader.readLine()) != null)
        {
            buffer += str;
        }
        return buffer;
    }

    protected Object invokeMethod(Class targetClass, String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] argClasses = new Class[args.length];
        for (int i=0; i<args.length;i++) {
            argClasses[i] = args[i].getClass();
        }
        Method method = targetClass.getDeclaredMethod(methodName, argClasses);
        method.setAccessible(true);
        return method.invoke(null, args);
    }

    protected void checkKeyValidation(JSONObject expectJson, JSONObject actualObject){
        Iterator<String> keys = expectJson.keys();
        while(keys.hasNext()){
            String key = keys.next();
            try {
                actualObject.get(key);
            } catch (JSONException e) {
                fail("in " + actualObject.toString() + "" + key + " does not exist");
            }
        }
    }
}
