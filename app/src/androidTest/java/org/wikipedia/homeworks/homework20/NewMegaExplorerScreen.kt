package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.AnnounceCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleCardViewItem
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReaderCardViewIteam

object NewMegaExplorerScreen : NamedKScreen<NewMegaExplorerScreen>() {
    override val screenName = "Главный экран"
    override val layoutId = null
    override val viewClass = null

    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }.name(withParent("Заголовок"))
    }

    val items = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::FeaturedArticleCardViewItem)
            itemType(::SearchCardViewItem)
            itemType(::AnnounceCardViewItem)
            itemType(::DayHeaderViewItem)
            itemType(::TopReaderCardViewIteam)
            itemType(::NewsCardViewItem)
        }
    ).name(withParent("Список блоков"))

    fun topReaderCardViewItem(index: Int, function:TopReaderCardViewIteam.()->Unit){
        items.invokeAtIndex(index,function)
    }

    fun topReadItem(): TopReaderCardViewIteam {
        return items.childWith<TopReaderCardViewIteam> {
            withDescendant {
                withText("Top read")
            }
        }.name(items.getName().withParent("Top read"))
    }
}

