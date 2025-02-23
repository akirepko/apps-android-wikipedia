package org.wikipedia.homeworks.homework03

import android.widget.Button
import android.widget.ImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.views.AppTextView


object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val forwardButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val mainImage = KImageView {
        withId(R.id.imageViewCentered)
    }
    val titleOnboarding = KTextView {
        withText(R.id.primaryTextView)
    }

    val  subTitleOnboarding = KTextView {
        withText(R.id.secondaryTextView)
    }


    val listOfLanguage =  KTextView {
        withText(R.id.option_label)
    }

    val addButtonLanguage =KButton {
        withText(R.id.addLanguageButton)
    }

}

val mainImage = listOf(
    ImageView::class.java,
    "imageViewCentered",
)

val titleOnboarding = listOf(
    AppTextView::class.java,
    "primaryTextView",
)

val subtitleOnboarding = listOf(
    AppTextView::class.java,
    "secondaryTextView",
)

val listOfLanguage = listOf(
    AppTextView::class.java,
    "option_label",
)

val addButtonLanguage = listOf(
    Button::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val skipButton = listOf(
    Button::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val forwardButton = listOf(
    Button::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)


