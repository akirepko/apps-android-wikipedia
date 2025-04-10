package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.homeworks.homework19.Steps

val TestContext<*>.steps : Steps
    get()= Steps(this)