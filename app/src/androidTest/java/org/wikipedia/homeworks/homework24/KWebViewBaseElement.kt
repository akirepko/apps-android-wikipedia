package org.wikipedia.homeworks.homework24

import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.web.KWebView
import io.github.kakaocup.kakao.web.WebElementBuilder
import org.wikipedia.homeworks.homework20.NameHierarchy

abstract class KWebViewBaseElement<T: KWebViewBaseElement<T>>( val kWebview : KWebView,  val xPath: String) {
    abstract val self:T
    private var name =NameHierarchy("nolabel")
    operator fun invoke (function: T.()->Unit){
        function(self)
    }

    infix fun perform(function: T.()->Unit) :T{
        function(self)
        return self
    }
    fun executeAction(interaction: WebElementBuilder.KWebInteraction.()->Unit){
        kWebview{
            withElement(Locator.XPATH, xPath,  interaction)
        }
    }
    fun name (name: NameHierarchy):T{
         this.name = name
         return  self
    }

    fun getName():NameHierarchy = name

    fun withParent (elementName:String)= NameHierarchy(elementName,name)
}