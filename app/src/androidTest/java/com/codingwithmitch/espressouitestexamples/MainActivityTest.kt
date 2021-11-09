package com.codingwithmitch.espressouitestexamples


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matchers.not
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @Test
    fun test_showDialog_captureNameInput() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val EXPECTED_NAME = "Bruno"

        //execute and verify
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withId(R.id.md_input_message)).perform(typeText(EXPECTED_NAME))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(doesNotExist())

        onView(withId(R.id.text_name)).check(matches(withText(EXPECTED_NAME)))


    }
}
