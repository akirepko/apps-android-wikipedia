package org.wikipedia.homeworks.homework8

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework8.screen.NewOnboardingScreen
import org.wikipedia.homeworks.homework8.screen.OnboardingPageItem
import org.wikipedia.main.MainActivity


class OnboardingScreenTest : TestCase() {
    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun startTest() {
        run {
            step("проверка работы приложения и теста))") {

                NewOnboardingScreen.slider.childAt<OnboardingPageItem>(0) {
                    imageView.isDisplayed()
                    primaryInfoText.isDisplayed()
                    secondaryInfoText.isDisplayed()
                    addLanguageBtn.isDisplayed()
                }
                NewOnboardingScreen {
                    skipButton.isDisplayed()
                    skipButton.isClickable()
                    forwardButton.isDisplayed()
                    forwardButton.isClickable()

                }
            }
        }
    }

    @Test
    fun secondTest() {
        run {
            step("second page") {
                NewOnboardingScreen.forwardButton.click()
                NewOnboardingScreen.slider.childAt<OnboardingPageItem>(1) {
                    imageView.isDisplayed()
                    primaryInfoText.isDisplayed()
                    secondaryInfoText.isDisplayed()
                    addLanguageBtn.isNotDisplayed()
                }
            }
        }
    }

    @Test
    fun thirdTest() {
        run {
            step(" переход на главную") {
                NewOnboardingScreen.forwardButton.click()
                NewOnboardingScreen.forwardButton.click()
                NewOnboardingScreen.forwardButton.click()
                NewOnboardingScreen.slider.childAt<OnboardingPageItem>(2) {
                    imageView.isDisplayed()
                    primaryInfoText.isDisplayed()
                    secondaryInfoText.isDisplayed()
                    addLanguageBtn.isNotDisplayed()
                }
                NewOnboardingScreen.doneButton {
                    isDisplayed()
                    isClickable()
                    click()
                }
            }
        }
    }
    @Test
    fun skipTest() {
        run {
            step("пропуск онбординга") {
                NewOnboardingScreen.skipButton.click()
                NewOnboardingScreen.skipButton.isNotDisplayed()
//                NewOnboardingScreen.slider.childAt<OnboardingPageItem>(0) {
//                    imageView.isNotDisplayed()
//                    primaryInfoText.isNotDisplayed()
//                    secondaryInfoText.isNotDisplayed()
//                    addLanguageBtn.isNotDisplayed()
//                }
            }
        }
    }
}

