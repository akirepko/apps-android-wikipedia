package org.wikipedia.homeworks.homework09.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object NewsViewScreen : KScreen<NewsViewScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>?= null

    val imageView= KImageView{withId(R.id.header_image_view)}

    val stories = KRecyclerView(
        builder = { withId(R.id.news_story_items_recyclerview) },
        itemTypeBuilder = {
            itemType(::StoriesViewItem)
        }
    )

}