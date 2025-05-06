package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.actions.SwipeableActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.wikipedia.homeworks.homework19.Steps
import org.wikipedia.homeworks.homework24.KWebViewElement

class NamedSteps(val testContext: TestContext<*>) {
    private fun execute(step: String, actions: (StepInfo) -> Unit) {
        testContext.step(step, actions)
    }

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }


    fun click(element: BaseActions) {
        execute("Нажимаем на элемент '${element.getName()}'") {
            element.click()
        }

    }
    fun isClikable(element: BaseAssertions) {
        execute("Элемент виден '${(element as BaseActions).getName()}'") {
            element.isClickable()
        }

    }

    fun swipeUp(element: SwipeableActions) {
        execute("Свапаем ${element.getName()} вверх") {
            element.swipeUp()
        }

    }

    fun scroll(element:KWebViewElement){
        execute("Свапаем ${element.getName()} вверх"){
            testContext.flakySafely (15000){
                element.executeAction { scroll() }
            }

        }
    }

    fun isDisplayed(element: BaseAssertions,) {
        execute("Элемент виден '${(element as BaseActions).getName()}'") {
            element.isDisplayed()
        }

    }
}