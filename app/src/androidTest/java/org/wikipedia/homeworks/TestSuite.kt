package org.wikipedia.homeworks

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.wikipedia.homeworks.homework07.ExplorerScreen
import org.wikipedia.homeworks.homework09.NewsScreenTest
import org.wikipedia.homeworks.homework10.OnboardingUiAtumatorScreenTest
import org.wikipedia.homeworks.homework11.DeviceTest
import org.wikipedia.homeworks.homework12.FistTest
import org.wikipedia.homeworks.homework13.WebviewTest
import org.wikipedia.homeworks.hw08.ExploreScreenTests

@RunWith(Suite::class)
@Suite.SuiteClasses(
    WebviewTest::class,
    FistTest::class,
    DeviceTest::class,
    OnboardingUiAtumatorScreenTest::class,
    NewsScreenTest::class,
    ExploreScreenTests::class,
)
class TestSuite
