

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.AnnounceCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReaderCardViewIteam
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework20.name

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Главный экран"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .name(withParent("Заголовок"))
    }
    val feed = KRecyclerView(
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

    fun topReadItem(index: Int, function: TopReaderCardViewIteam.() -> Unit) {
        feed.invokeAtIndex(index, function)
    }

    fun topReadItem(): TopReaderCardViewIteam {
        return feed.childWith<TopReaderCardViewIteam> {
            withDescendant {
                withText("Top read")
            }
        }.name(feed.getName().withParent("Top read"))
    }


}