package com.doubley.customandroidtest.sampleapp

import android.test.ActivityInstrumentationTestCase2
import android.test.AndroidTestCase
import com.doubley.customandroidtest.custom_test.util.ContextUtil
import com.doubley.customandroidtest.custom_test.util.FileUtil
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import kotlin.test.fail

/**
 * Created by yasudayousuke on 9/1/15.
 */
public class AssetTest : AndroidTestCase() {

    Test
    fun testReadAssetFile(){
        val mContext = ContextUtil.getTestContext(this)
        if(mContext != null){
            assertThat("this is test", equalTo(FileUtil.getStringFromAsset(mContext, "test.txt")))
        }else{
            fail("Context is null")
        }
    }
}