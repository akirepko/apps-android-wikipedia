package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReaderCardViewIteam(matcher: Matcher<View>) :
    KRecyclerItem<TopReaderCardViewIteam>(matcher) {
    val  titleTopReader = KTextView (matcher){withId(R.id.view_card_header_title)}
    val  moreActione = KTextView (matcher){withId(R.id.footerActionButton)}


    val imageHeader =  KImageView (matcher){withId(R.id.view_card_header_title)}
        val items = KRecyclerView (
            parent = matcher,
            builder = {withId(R.id.view_list_card_list)},
            itemTypeBuilder = {
                itemType(::ListCardItemView)
            },

        )
}