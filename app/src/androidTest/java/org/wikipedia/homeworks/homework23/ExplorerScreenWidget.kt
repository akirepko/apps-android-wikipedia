package org.wikipedia.homeworks.homework23

import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.ExplorerScreenNew
import org.hamcrest.core.AllOf.allOf
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.name

object ExplorerScreenWidget : NamedKScreen<ExplorerScreenWidget>() {
    override val screenName = "Main screen"
    override val layoutId = null
    override val viewClass = null
    val searchWidget by lazy {

        SearchWidget { withId(R.id.search_container) }.name(ExplorerScreenNew.withParent("поиск"))
    }

    val topReadWidget by lazy {
        TopReadWidget(
            matcher = allOf(
                isDescendantOfA(withId(R.id.feed_view)),
                hasDescendant(withText("Top read"))
            )
        ) {
        }.name(withParent("Виджет 'Top Read'"))
    }
}


