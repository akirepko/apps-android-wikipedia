package org.wikipedia.homeworks.homework12

import androidx.test.espresso.AmbiguousViewMatcherException
import androidx.test.espresso.web.matcher.AmbiguousElementMatcherException
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

class FistTest : TestCase(kaspressoBuilder = Kaspresso.Builder.advanced {
    flakySafetyParams = FlakySafetyParams.custom(timeoutMs = 3000,
        allowedExceptions = FlakySafetyParams.defaultAllowedExceptions.plus(AmbiguousViewMatcherException::class.java)
    )
}
)