package com.example.hearthstonelist.fragmentTests

import android.view.Gravity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.hearthstonelist.R
import com.example.hearthstonelist.ui.view.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WarriorCardListFragmentTests {

    /* To do
        Mock Dependency Injection
        Mock Api Response
    */

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.drawer_layout))
            .check(matches(DrawerMatchers.isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.nav_warrior))
            .perform(click())
    }

    @Test
    fun shouldShowCardImage() {
        Thread.sleep(1000)
        onView(withId(R.id.image_class))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowProgressBar() {
        onView(withId(R.id.progress_circular))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowCardList() {
        Thread.sleep(30000)
        onView(withId(R.id.recycler_cards))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowJoke() {
        onView(withId(R.id.text_joke))
            .check(matches(isDisplayed()))
    }
}
