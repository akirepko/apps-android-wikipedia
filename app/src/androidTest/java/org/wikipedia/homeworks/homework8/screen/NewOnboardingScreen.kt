package org.wikipedia.homeworks.homework8.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object NewOnboardingScreen : KScreen<NewOnboardingScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val forwardButton = KButton  {
        withId(R.id.fragment_onboarding_forward_button)
    }
    val doneButton = KButton{
        withId(R.id.fragment_onboarding_done_button)
    }
    val pageIndicator = KView{
        withId(R.id.view_onboarding_page_indicator)
    }


    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPageItem)
        }
    )

}