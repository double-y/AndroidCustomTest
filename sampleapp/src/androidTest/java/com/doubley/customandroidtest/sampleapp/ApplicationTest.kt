package com.doubley.customandroidtest.sampleapp

import android.app.Application
import android.support.test.runner.AndroidJUnit4
import android.test.ApplicationTestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers.equalTo
import kotlin.test.assertEquals

/**
 * [Testing Fundamentals](http://d.android.com/tools/testing/testing_android.html)
 */
RunWith(AndroidJUnit4::class)
public class ApplicationTest : ApplicationTestCase<Application>(javaClass<Application>()) {
    Before
    fun setup() {}

    After
    fun teardown() {}

    Test
    fun test(){
        assertThat("sample", equalTo("sample"))
    }
}