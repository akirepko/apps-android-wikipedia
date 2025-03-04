package org.wikipedia.lesson.lesson10

import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName: String = "org.wikipedia"

    val image = UiTextView
}