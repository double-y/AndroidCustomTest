package com.doubley.customandroidtest.custom_test.util

import android.util.Log

/**
 * Created by yasudayousuke on 9/3/15.
 */
public object LoggerUtil {
    fun d(tag: String, msg: String){
        Log.d(tag, msg)
    }
}