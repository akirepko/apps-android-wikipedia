package org.wikipedia.homeworks.homework09.screen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class StoriesViewItem(matcher: Matcher<View>) : KRecyclerItem<StoriesViewItem>(matcher) {
    val titleStories = KTextView(matcher) { withId(R.id.view_list_card_item_title) }
    val subTitleStories = KTextView(matcher) { withId(R.id.view_list_card_item_subtitle) }
}