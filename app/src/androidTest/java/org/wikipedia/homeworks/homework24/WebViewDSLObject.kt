package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen

object WebViewDSLObject:NamedKScreen<WebViewDSLObject>() {
    override val screenName="Webview"
    override val layoutId=null
    override val viewClass= null


    val webView by lazy{
        KWebView{
            withId(R.id.page_web_view)
        }
    }

    val refernces by  lazy{
        webView.withXpath( "//*[@id='References']",).name(withParent("Ссылки"))
    }
}