package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView

class KWebViewList(kWebview: KWebView, xPath: String) :
    KWebViewBaseElement<KWebViewList>(kWebview, xPath) {
    override val self: KWebViewList= this
    inline fun <reified T: KWebViewItem<T>> childAt(index:Int, function:T.()->Unit){
        val item = T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(kWebview, "$xPath/*[$index]")

    }
}