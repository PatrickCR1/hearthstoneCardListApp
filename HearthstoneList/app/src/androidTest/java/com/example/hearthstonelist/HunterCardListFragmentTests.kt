package com.example.hearthstonelist

import android.view.Gravity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers
import androidx.test.espresso.matcher.ViewMatchers
import com.example.hearthstonelist.ui.view.MainActivity
import org.junit.Before
import org.junit.Test

class HunterCardListFragmentTests {

    @Before
    fun shouldNavigateToClassFragment() {
        ActivityScenario.launch(MainActivity::class.java)

        Espresso
            .onView(ViewMatchers.withId(R.id.drawer_layout))
            .check(ViewAssertions.matches(DrawerMatchers.isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        Espresso
            .onView(ViewMatchers.withId(R.id.nav_hunter))
            .perform(ViewActions.click())
    }

    @Test
    fun shouldShowCardImage() {
        Thread.sleep(1000)
        Espresso
            .onView(ViewMatchers.withId(R.id.image_class))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldShowProgressBar() {
        Espresso
            .onView(ViewMatchers.withId(R.id.progress_circular))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldShowCardList() {
        Thread.sleep(30000)
        Espresso
            .onView(ViewMatchers.withId(R.id.recycler_cards))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
