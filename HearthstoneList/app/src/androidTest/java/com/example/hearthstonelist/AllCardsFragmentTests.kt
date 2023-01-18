package com.example.hearthstonelist

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.hearthstonelist.ui.view.MainActivity
import org.junit.Test

class AllCardsFragmentTests {

    @Test
    fun shouldShowToolBarText() {
        ActivityScenario.launch(MainActivity::class.java)
        Espresso
            .onView(ViewMatchers.withId(R.id.toolbar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldShowClassImage() {
        ActivityScenario.launch(MainActivity::class.java)
        Espresso
            .onView(ViewMatchers.withId(R.id.image_class))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldShowProgressBar() {
        ActivityScenario.launch(MainActivity::class.java)
        Espresso
            .onView(ViewMatchers.withId(R.id.progress_circular))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldShowRecyclerCardList() {
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(40000)
        Espresso
            .onView(ViewMatchers.withId(R.id.recycler_cards))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
