package org.wikipedia.homeworks.homework23

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework20.NewMegaOnboardingScreen
import org.wikipedia.main.MainActivity

class Test23:TestCase() {
    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWithWidget(){
        run{
            namedSteps{
                isClikable(NewMegaOnboardingScreen.skipButton)
                click(NewMegaOnboardingScreen.skipButton)
               ExplorerScreenWidget.searchWidget{
                    isDisplayed(voiceIcon)
                   isDisplayed(searchIcon)
                }
            }
        }
    }

    @Test
    fun topTestWidget(){
        run{
            namedSteps{
                isClikable(NewMegaOnboardingScreen.skipButton)
                click(NewMegaOnboardingScreen.skipButton)
               device.uiDevice.swipe(device.uiDevice.displayWidth / 2,
                   device.uiDevice.displayHeight * 2 / 3,
                   device.uiDevice.displayWidth / 2,
                   device.uiDevice.displayHeight / 4,
                   10
               )
                Thread.sleep(500)
                ExplorerScreenWidget.topReadWidget{
                    isDisplayed(titleTopReader)
                    isDisplayed(moreActione)
                    isDisplayed(imageHeader)
                }
            }
        }
    }
}