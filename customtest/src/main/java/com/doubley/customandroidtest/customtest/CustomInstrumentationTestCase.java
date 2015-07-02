package com.doubley.customandroidtest.customtest;

import android.content.res.AssetManager;
import android.test.InstrumentationTestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
}
