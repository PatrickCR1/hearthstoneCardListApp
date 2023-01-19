package com.example.hearthstonelist.fragmentTests

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.hearthstonelist.R
import com.example.hearthstonelist.ui.view.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AllCardsFragmentTests {

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun shouldShowToolBarText() {
        onView(withId(R.id.toolbar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowClassImage() {
        onView(withId(R.id.image_class))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowProgressBar() {
        onView(withId(R.id.progress_circular))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowRecyclerCardList() {
        Thread.sleep(40000)
        onView(withId(R.id.recycler_cards))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowJoke() {
        onView(withId(R.id.text_joke))
            .check(matches(isDisplayed()))
    }
}
