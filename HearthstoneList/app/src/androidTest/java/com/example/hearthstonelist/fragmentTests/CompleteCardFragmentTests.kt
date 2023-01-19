package com.example.hearthstonelist.fragmentTests

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.hearthstonelist.R
import com.example.hearthstonelist.ui.view.MainActivity
import com.example.hearthstonelist.ui.viewholder.CardsViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CompleteCardFragmentTests {

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(40000)
        onView(withId(R.id.recycler_cards))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CardsViewHolder>(0, click()))
    }

    @Test
    fun shouldShowCardImage() {
        onView(withId(R.id.image_card))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowCardInformation() {
        onView(withId(R.id.text_card_name))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_text))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_flavor))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_rarity))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_set))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_type))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_faction))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_cost))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_attack))
            .check(matches(isDisplayed()))
        onView(withId(R.id.text_card_health))
            .check(matches(isDisplayed()))
    }
}
