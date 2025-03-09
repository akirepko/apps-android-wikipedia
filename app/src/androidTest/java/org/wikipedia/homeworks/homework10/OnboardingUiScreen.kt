package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val viewPager = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "scrollViewContainer")
    }

    val image = UiView{
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val titleUi = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val subTitleUi = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }
}