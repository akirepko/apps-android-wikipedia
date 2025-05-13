package org.wikipedia.homeworks

import com.kaspersky.components.alluresupport.files.attachScreenshotToAllureReport
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.screenshots.Screenshots
import com.kaspersky.kaspresso.interceptors.watcher.testcase.StepWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.testcases.models.info.StepInfo

abstract class AllureSupportTest:TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf{
            it is ScreenshotStepInterceptor
        }
        stepWatcherInterceptors.add(FailOnlyScreenshotStepInterceptor(screenshots))
    }
)

class FailOnlyScreenshotStepInterceptor(
    private val screenshots: Screenshots
) : StepWatcherInterceptor {


    override fun interceptAfterWithError(stepInfo: StepInfo, error: Throwable) {
        intercept("${makeTag(stepInfo)}_failure_${error.javaClass.simpleName}")
    }

    private fun intercept(tag: String) {
        screenshots.takeAndApply(tag) { attachScreenshotToAllureReport() }
    }

    private fun makeTag(stepInfo: StepInfo): String = "${stepInfo.testClassName}_step_${stepInfo.ordinal}"
}