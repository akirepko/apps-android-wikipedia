package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ListCardItemView
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadWidget : KWIdget<TopReadWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)


    val titleTopReader by lazy {
        KTextView(parent) { withId(R.id.view_card_header_title) }.name(
            withParent("Title")
        )
    }
    val moreActione by lazy {
        KTextView(parent) { withId(R.id.footerActionButton) }.name(
            withParent("Кнопка больше")
        )
    }


    val imageHeader by lazy { KImageView(parent) { withId(R.id.view_card_header_title) }.name(withParent("Картинка")) }
    val items by lazy {
        KRecyclerView(
            parent = parent,
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {
                itemType(::ListCardItemView)
            }

        ).name(withParent("несчо"))
    }

    fun topReadWidgetItems(index: Int, function: ListCardItemView.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

}