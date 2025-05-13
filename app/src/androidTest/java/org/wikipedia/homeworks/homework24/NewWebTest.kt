package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExplorerScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework19.Steps
import org.wikipedia.homeworks.homework24.WebViewDSLObject
import org.wikipedia.homeworks.homework8.screen.NewOnboardingScreen
import org.wikipedia.main.MainActivity

class NewWebTest:TestCase(Kaspresso.Builder.withForcedAllureSupport ()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest(){

        run{
            steps{
                click(OnboardingScreen.skipButton, "Кнопка Skip")
                ExplorerScreen.items.childWith<SearchCardViewItem> {
                    withDescendant { withText("Featured article") }
                }.perform {
                    steps.isVisible(this, "some")
                    sleep(1222)
                    click() }
                WebViewDSLObject.webView
                WebViewDSLObject.refernces{

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
                    withElement(Locator.XPATH,"//sup[contains(@class,'refernces']"){
                        click()

                    }
                }

            }
        }
        ScrollViewScreen.description.hasText("5")
        device.uiDevice.pressBack()
        ArticleViewScreen{
            webview {
                withElement(Locator.CSS_SELECTOR,"> section:nth-child(3) > p:nth-child(5) > a:nth-child(8)"){
                    click()

                }
            }
        }
        ArticleViewScreen{
            webview {
                withElement(Locator.ID,"Bibliography"){
                    scroll()

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