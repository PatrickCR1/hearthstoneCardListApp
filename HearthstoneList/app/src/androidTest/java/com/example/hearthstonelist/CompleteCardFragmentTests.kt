package com.example.hearthstonelist

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.hearthstonelist.ui.view.MainActivity
import com.example.hearthstonelist.ui.viewholder.CardsViewHolder
import org.junit.Before
import org.junit.Test

class CompleteCardFragmentTests {

    @Before
    fun shouldNavigateToCompleteCardFragment() {
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(40000)
        Espresso
            .onView(ViewMatchers.withId(R.id.text_card_name))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CardsViewHolder>(0, ViewActions.click()))
    }

    @Test
    fun shouldShowCardImage() {
        Espresso
            .onView(ViewMatchers.withId(R.id.image_card))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
