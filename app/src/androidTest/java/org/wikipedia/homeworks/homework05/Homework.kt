package org.wikipedia.homeworks.homework05

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher


enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

data class Shape(val longSides: Float, val quantySide: Int, val color: Color)

class LongSidesInRangeMatcher(
    private val min: Float,
    private val max: Float
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("длина стороны в диапазоне от $min до $max")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.longSides in min..max
    }
}


fun hasSideLengthInRange(min: Float, max: Float) = LongSidesInRangeMatcher(min, max)

class CornerMatcher(
    private val quantySide: Int
) : TypeSafeMatcher<Shape>() {


    override fun describeTo(description: Description) {
        description.appendText("количество углов $quantySide")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return when {
            item.quantySide >= 3 -> item.quantySide == item.quantySide
            item.quantySide == 1 || item.quantySide == 2 -> true
            else -> false
        }
    }
}

fun hasCorner(quantySide: Int) = CornerMatcher(quantySide)
class EvenQuantyMatcher(

) : TypeSafeMatcher<Shape>() {


    override fun describeTo(description: Description) {
        description.appendText("количество сторон  четное")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return when {
            item.quantySide % 2 == 0 -> true
            else -> false
        }
    }
}

fun hasEvenQuanty() =EvenQuantyMatcher()
class ColorMatcher(
    private val expectedColor: Color
) : TypeSafeMatcher<Shape>() {


    override fun describeTo(description: Description) {
        description.appendText("цвет $expectedColor")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == expectedColor
    }
}
fun hasColor(expectedColor: Color) = ColorMatcher(expectedColor)
class NegativeSideLengthMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("длина стороны не должна быть отрицательной")
    }
    override fun matchesSafely(item: Shape): Boolean {
        return item.longSides >= 0
    }
}
fun hasValidSideLength() = NegativeSideLengthMatcher()

class NegativeSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("количество сторон не должно быть отрицательным")
    }
    override fun matchesSafely(item: Shape): Boolean {
        return item.quantySide >= 0
    }
}
fun hasValidSides() = NegativeSidesMatcher()
val shapes = listOf(
    Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
    Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
    Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
    Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
    Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
    Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
    Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
)
val filteredShapes = shapes.filter { shape ->
    allOf(
        hasSideLengthInRange(1f, 20f),
        hasColor(Color.RED),
        hasValidSideLength(),
        hasValidSides(),
        hasEvenQuanty(),
        hasCorner(1),
    ).matches(shape)
}

fun testMatchers() {
    val shape = Shape(10f, 4, Color.RED)
    assertThat(shape, hasSideLengthInRange(1f, 20f))
    assertThat(shape, hasColor(Color.RED))
    assertThat(shape, hasValidSideLength())
    assertThat(shape, hasValidSides())
}
fun main() {
    testMatchers()
    println("Фигуры, прошедшие фильтрацию: $filteredShapes")
}
