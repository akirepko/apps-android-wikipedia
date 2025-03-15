package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ScrollViewScreen : KScreen<ScrollViewScreen>() {
    override val layoutId = null
    override val viewClass = null

    val title = KTextView{withId(R.id.reference_title_text)}
    val description = KTextView{withId(R.id.reference_id)}


}