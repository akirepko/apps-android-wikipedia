package org.wikipedia.homeworks.hw08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExplorerScreen
import org.wikipedia.homeworks.homework07.ListCardItemView
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReaderCardViewIteam
import org.wikipedia.main.MainActivity
import org.wikipedia.page.PageActivity

class ExploreScreenTests : TestCase() {

    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun simpleTest() {
        run {
            step("Skipping") {
                OnboardingScreen.skipButton.click()
            }
            step("Проверяет отображение тулбара") {
                ExplorerScreen.title.isDisplayed()
            }
            step("Checking logo of mic in search") {
                ExplorerScreen.items.childAt<SearchCardViewItem>(0) {
                    voiceIcon.isDisplayed()
                }
            }
            step("Checking has logo in 2nd child in topRead") {
                ExplorerScreen.items.swipeUp()
                ExplorerScreen.items.childAt<TopReaderCardViewIteam>(4) {
                    step("TopReadCardViewItem.isDisplayed()") {
                        isDisplayed()
                    }
                    items.childAt<ListCardItemView>(1) {
                        image.isDisplayed()
                    }
                }
            }
        }
    }
}
