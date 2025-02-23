package org.wikipedia.homeworks.homework8.screen

import io.github.kakaocup.kakao.pager2.KViewPagerItem
import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
class OnboardingPageItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingPageItem>(matcher) {
    val imageView = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val primaryInfoText = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val secondaryInfoText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }


    val addLanguageBtn = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }
}