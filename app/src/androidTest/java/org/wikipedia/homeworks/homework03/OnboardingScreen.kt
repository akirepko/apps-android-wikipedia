package org.wikipedia.homeworks.homework03

import android.widget.Button
import android.widget.ImageView
import org.wikipedia.views.AppTextView

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


