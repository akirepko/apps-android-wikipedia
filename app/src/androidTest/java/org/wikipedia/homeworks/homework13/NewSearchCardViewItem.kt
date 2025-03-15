package org.wikipedia.homeworks.homework13

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.SearchCardViewItem

class NewSearchCardViewItem(matcher: Matcher<View>) : KRecyclerItem<SearchCardViewItem>(matcher) {
    val title = KTextView(matcher){withId(R.id.page_list_item_title)}
    val decsription = KTextView(matcher){withId(R.id.page_list_item_description)}
    val image = KTextView(matcher){withId((R.id.page_list_item_image))}
}