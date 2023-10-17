package com.example.movementapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun showComponentsOnLaunch() {
        onView(withId(R.id.accelerometer)).check(matches(isDisplayed()))
        onView(withId(R.id.sensitivityTextView)).check(matches(isDisplayed()))
        onView(withId(R.id.sensitivitySeekBar)).check(matches(isDisplayed()))
    }
}