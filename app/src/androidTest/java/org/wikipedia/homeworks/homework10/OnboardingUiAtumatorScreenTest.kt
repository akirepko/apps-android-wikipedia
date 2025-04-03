package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiAtumatorScreenTest : TestCase((Kaspresso.Builder.withForcedAllureSupport ())) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkImageIsView() {
        run {
            step("Кртинка на месте") {
                OnboardingUiScreen.image {
                    isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkTitleView() {
        run {
            step("текст заголовка один на месте") {

                OnboardingUiScreen.viewPager.swipeRight()
                OnboardingUiScreen.titleUi {
                    isDisplayed()
                }

            }
        }
    }

    @Test
    fun checkSubTitleView() {
        run {
            step("Кртинка на месте") {

                OnboardingUiScreen.viewPager.swipeRight()
                OnboardingUiScreen.subTitleUi {
                    isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkNavigationButtons() {

        run {
            step("Закртие онбординга'") {
                OnboardingUiScreen.skipButton{
                    isDisplayed()
                    isClickable()
                    click()
                }

            }

        }
    }
}
