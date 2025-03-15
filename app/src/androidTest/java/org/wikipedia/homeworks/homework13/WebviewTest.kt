package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExplorerScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.main.MainActivity

class WebviewTest:TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest(){
        run{
            OnboardingScreen.skipButton.click()
            ExplorerScreen.items.childWith<SearchCardViewItem> {
                withDescendant { withText("Featured article") }
            }.perform {
                Thread.sleep(1222)
                click() }
            ArticleViewScreen{
                webview {
                    withElement(Locator.CSS_SELECTOR,"mw-page-title-main"){
                        hasText("Five pounds (gold coin)")
                    }
                }
            }
        }
    }

    @Test
    fun webViewTest1(){
        run{
            OnboardingScreen.skipButton.click()
            ExplorerScreen.items.childWith<SearchCardViewItem> {
                withDescendant { withText("Featured article") }
            }.perform {
                Thread.sleep(1222)
                click() }
            ArticleViewScreen{
                webview {
                    withElement(Locator.ID,"Bibliography"){
                       scroll()

                    }
                }
            }
        }
    }
    @Test
    fun webViewTest2(){
        run{
            OnboardingScreen.skipButton.click()
            ExplorerScreen.items.childWith<SearchCardViewItem> {
                withDescendant { withText("Featured article") }
            }.perform {
                Thread.sleep(1222)
                click() }
            ArticleViewScreen{
                webview {
                    withElement(Locator.ID,"References"){
                        scroll()

                    }
                }
            }
        }
    }

    @Test
    fun webViewTest3(){
        run{
            OnboardingScreen.skipButton.click()
            ExplorerScreen.items.childWith<SearchCardViewItem> {
                withDescendant { withText("Featured article") }
            }.perform {
                Thread.sleep(1222)
                click() }
            ArticleViewScreen{
                webview {
                    withElement(Locator.ID,"References"){
                        scroll()

                    }
                }
            }
        }
    }
    @Test
    fun searchViewTest(){
        run{
            OnboardingScreen.skipButton.click()
            ExplorerScreen.items.childAt<SearchCardViewItem>(0){
                searchText.click()
            }
            SearchScreen.searchInput.click()
            SearchScreen.searchInput.replaceText("Ru")
//            SearchScreen.items.childAt<NewSearchCardViewItem>()
        }
    }
}