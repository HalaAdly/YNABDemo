package com.hm.ynabdemo.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.hm.ynabdemo.DataStatus
import com.hm.ynabdemo.R
import com.hm.ynabdemo.TestUtil.dataStatus
import com.hm.ynabdemo.ui.budgetDetails.BudgetDetailsActivity
import com.hm.ynabdemo.utils.EspressoIdlingResource
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java, false, false)
    private var mIdlingResource: IdlingResource? = null

    @get:Rule
    var budgetDetailsActivity: IntentsTestRule<BudgetDetailsActivity> =
        IntentsTestRule(BudgetDetailsActivity::class.java)

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun displayBudgetsList() {
        dataStatus = DataStatus.Success
        mActivityTestRule.launchActivity(null)
        Espresso.onView(withId(R.id.rv_list))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.pb_loading))
            .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun noData() {
        dataStatus = DataStatus.Fail
        mActivityTestRule.launchActivity(null)
        Espresso.onView(withId(R.id.pb_loading)).check(matches(not(doesNotExist())))
        Espresso.onView(withId(R.id.rv_list)).check(matches(not(doesNotExist())))
//        Espresso.onView(withId(R.id.tv_no_data))
//            .check(matches(isDisplayed()))

    }

    //
//
    @Test
    fun testOpenDetails() {
        dataStatus = DataStatus.Success
        mActivityTestRule.launchActivity(null)
        Espresso.onView(withId(R.id.rv_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        // check is activity was started
        intended(hasComponent(BudgetDetailsActivity::class.java.name))
    }

    @After
    fun unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister()
        }
    }
}