package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId = null
    override val viewClass = null

    val searchInput = KEditText { withId(R.id.searchCabView) }
    val items = KRecyclerView(
        builder = {
            withId(
                R.id.search_results_list
            )
        },
        itemTypeBuilder = { itemType(::NewSearchCardViewItem) }
    )

}