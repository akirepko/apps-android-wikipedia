package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import javax.xml.xpath.XPath

fun KWebView.withXpath (xPath: String)= KWebViewElement(this, xPath)