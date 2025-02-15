package org.wikipedia.lesson

import android.widget.ImageView
import android.widget.LinearLayout
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val imageViewCentered = KImageView {
    withId(R.id.imageViewCentered)
}

val sloganOfWiki = KTextView {
    withText(R.string.onboarding_welcome_title_v2)
    withId(R.id.primaryTextView)
    isInstanceOf(AppTextView::class.java)
    withParent { LinearLayout::class.java }
}

fun main() {
    imageViewCentered.isDisplayed()
}