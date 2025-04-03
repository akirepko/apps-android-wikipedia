package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExplorerScreen
import org.wikipedia.homeworks.homework07.NewsCardItem
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework09.screen.NewsViewScreen
import org.wikipedia.homeworks.homework09.screen.StoriesViewItem
import org.wikipedia.homeworks.homework09.screen.WikiArticleViewScreen
import org.wikipedia.main.MainActivity

class NewsScreenTest: TestCase((Kaspresso.Builder.withForcedAllureSupport ())) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun strangeTest() {
        run {
            step("Skipping") {
                OnboardingScreen.skipButton.click()
            }

            step("Найти статью"){
                ExplorerScreen.items.childWith<NewsCardViewItem> {
                    withDescendant { withText(R.string.view_card_news_title) } }
            }
            step("клик на статью"){
             ExplorerScreen.items.childWith<NewsCardViewItem> {
                 withDescendant { withText(R.string.view_card_news_title) }
             }.perform {
                 news.childAt<NewsCardItem>(2) {
                     newsImage.click()
                 }
             }
            }




            step("клик на 2  тайтл"){
                NewsViewScreen.stories.childAt<StoriesViewItem>(2){
                   titleStories.click()
                }

            }
            step("проверка отображаения "){
                WikiArticleViewScreen.viewArticl.isDisplayed()
            }
        }
    }
}