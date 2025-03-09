package org.wikipedia.homeworks.homeworks11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExplorerScreen
import org.wikipedia.homeworks.homework07.TopReaderCardViewIteam
import org.wikipedia.main.MainActivity
import java.util.Locale

class DeviceTest : TestCase() {

    @get:Rule

    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest() {
        before {
            device.network.disable()

        }.after {
            device.network.enable()
            device.language.switchInApp(Locale.ENGLISH)
        }

            .run {
//          device.uiDevice.wakeUp()
//          device.uiDevice.findObject(UiSelector().text("sds").packageName("")).isClickable
//            device.exploit.setAutoRotationEnabled(Exploit.DeviceOrientation.Landscape)
                Thread.sleep(3000)
                device.language.switchInApp(Locale.FRANCE)

                Thread.sleep(3000)
            }
    }

    @Test
    fun oriientationTest() {
        before {

        }.after {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }.run {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
            device.uiDevice.isNaturalOrientation

        }

    }

    @Test
    fun offScreenTest() {
        before {

        }.after {

        }.run {

            device.uiDevice.wakeUp()
            device.uiDevice.wakeUp()
            OnboardingScreen.mainImage.isDisplayed()

        }
    }

    @Test
    fun collapseTest() {
        run {
            device.uiDevice.pressHome()
            device.uiDevice.pressRecentApps()
            device.uiDevice.pressRecentApps()
            OnboardingScreen.skipButton.isDisplayed()
        }
    }
    @Test
    fun internetDisabled(){
        before {  }

            .after {
                device.network.enable()
            }.run{
                OnboardingScreen.skipButton.click()
                    ExplorerScreen.items.childWith<TopReaderCardViewIteam> {
                        withDescendant { withText("Top read") } }.perform {
                        titleTopReader.click()


                }
            }


    }

}