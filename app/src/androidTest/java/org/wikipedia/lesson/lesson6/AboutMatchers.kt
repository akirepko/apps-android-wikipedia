package org.wikipedia.lesson.lesson6

//import androidx.test.espresso.matcher.ViewMatchers.assertThat
//import junit.framework.TestCase.assertTrue
//import org.apache.commons.lang3.Range.`is`
//
//
//import org.hamcrest.MatcherAssert.assertThat
//import org.hamcrest.Matchers.allOf
//import org.hamcrest.Matchers.anyOf
//import org.hamcrest.Matchers.equalTo
//import org.hamcrest.Matchers.greaterThanOrEqualTo
//import org.hamcrest.Matchers.`in`
//
//import org.hamcrest.Matchers.lessThanOrEqualTo
//
//data class SuspiciousActivity(val isDetected: Boolean, val suspicionLevel: Int, val notes: String)
//
//fun ifStyle(activity: SuspiciousActivity) {
//    if (!activity.isDetected ||
//        activity.suspicionLevel !in 5..10 ||
//        !(activity.notes == "unusual behavior" || activity.notes == "unauthorized access")
//    ) {
//
//        throw AssertionError("Verification failed for: $activity")
//    }
//}
////fun assertStyle(activity: SuspiciousActivity) {
////    assertTrue(activity.isDetected, "Activity should be detected")
////    assertTrue(
////        activity.suspicionLevel in 5..10,
////        "Suspicion level should be within the range 5 to 10"
////    )
////    assertTrue(
////        activity.notes == "unusual behavior" || activity.notes == "unauthorized access",
////        "Notes should be valid"
////    )
////}
//
//fun matcherStyle(activity: SuspiciousActivity) {
//    assertThat("isDetected field", activity.isDetected, `is`(true))
//
//    assertThat(
//        "suspicionLevel field",
//        activity.suspicionLevel,
//        allOf(greaterThanOrEqualTo(5), lessThanOrEqualTo(10))
//    )
//
//    assertThat(
//        "notes field",
//        activity.notes,
//        anyOf(equalTo("unusual behavior"), `in`(listOf("unauthorized access")))
//    )
//}

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher


data class SuspiciousActivity(val isDetected: Boolean, val suspicionLevel: Int, val notes: String)
class IsDetectedMatcher(
    private val isDetected: Boolean
) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("isDetected is $isDetected")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.isDetected == isDetected
    }
}

class SuspicionLevelInRangeMatcher(
    private val min: Int,
    private val max: Int
) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("suspicionLevel is between $min and $max")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.suspicionLevel in min..max
    }
}


class NotesInMatcher(private val validNotes: List<String>) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("notes is one of $validNotes")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.notes in validNotes
    }
}
class MatcherBuilder(){
    val listOfMatchers = mutableListOf<Matcher<SuspiciousActivity>>()

    operator fun invoke(function:MatcherBuilder.()->Unit){
        function()
    }
}
fun main() {
    val activities = listOf(
        SuspiciousActivity(true, 5, "unauthorized access"),
        SuspiciousActivity(false, 4, "unauthorized access")
    )

    val matchers = allOf(
        SuspicionLevelInRangeMatcher(3,4),
        NotesInMatcher(listOf("unauthorized access", "security breach"))
    )
    val result = activities.filter { matchers.matches(it) }


    println(result)
}
