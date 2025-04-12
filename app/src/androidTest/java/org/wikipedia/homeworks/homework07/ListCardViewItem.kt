package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class ListCardItemView(
    matcher: Matcher<View>
) : KRecyclerItem<ListCardItemView>(matcher) {

    val number = KTextView(matcher) {
        withId(R.id.numberView)
    }

    val title = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val graph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val pageviews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }

    val image by  lazy { KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }.name(withParent("Картинка")) }
}