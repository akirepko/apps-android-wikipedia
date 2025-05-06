package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView

class KWebViewElement(kWebview: KWebView, xPath: String) :
    KWebViewBaseElement<KWebViewElement>(kWebview, xPath) {
    override val self: KWebViewElement = this
}