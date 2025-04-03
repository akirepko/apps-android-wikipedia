package org.wikipedia.homeworks.homework07

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView


object ExplorerScreen : KScreen<ExplorerScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val title = KImageView() {
        withId(R.id.main_toolbar_wordmark)
    }

    val items =KRecyclerView(
        builder = {
           withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::FeaturedArticleCardViewItem)
            itemType(::SearchCardViewItem)
            itemType(::AnnounceCardViewItem)
            itemType(::DayHeaderViewItem)
            itemType(::TopReaderCardViewIteam)
            itemType(::NewsCardViewItem)

        }
    )
}