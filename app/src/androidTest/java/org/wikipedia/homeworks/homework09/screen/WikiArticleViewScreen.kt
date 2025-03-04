package org.wikipedia.homeworks.homework09.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object WikiArticleViewScreen : KScreen<WikiArticleViewScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val viewArticl = KView {withId(R.id.page_web_view )}
}