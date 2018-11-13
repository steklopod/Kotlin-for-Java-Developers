package learnkotlin._17whenexpression

import java.math.BigDecimal

enum class Seasons {
    SPRING, SUMMER, AUTUMN, WINTER
}

fun main(args: Array<String>) {

    // the when expression is similar to the switch in Java, just better
    // basic example
    val num = 555
    when (num) {
        100 -> println("100")
        200 -> println("200")
        300 -> println("300")
        // we can test several values at once
        400, 500 -> println("400 or 500")
        // we can use ranges with in
        in 501..599 -> println("between 501 and 599")
        else -> println("no match")
    }

    // we can test against expressions
    val num2 = 515
    when (num) {
        num2 + 40 -> println("num is num2 plus 40")
    }

    // rather than doing type checking in a bunch of if-else-statements we can do it more concisely in the when with
    // smart casting
    val obj1: Any = "i'm a string"
    val obj2: Any = BigDecimal(22.5)
    val obj3: Any = 44
    val something = obj2

    val x = when (something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.abs())
        is Int -> println("${something / 22}")
        // if we add an else line, we can also assign the result to a variable
        else -> println("I have no idea what you are")
    }
    println(x.javaClass)

    // same example, but we can make each case return a value
    val y = when (something) {
        is String -> {
            println(something.toUpperCase())
            1
        }
        is BigDecimal -> {
            println(something.abs())
            2
        }
        is Int -> {
            println("${something / 22}")
            3
        }
        else -> {
            println("I have no idea what you are")
            -1
        }
    }
    println("y has value $y and is of type ${y.javaClass }")

    // we can use it with enums too. note that we do not need an else if we use all values in the enum
    val timeOfYear = Seasons.WINTER
    val str = when (timeOfYear) {
        Seasons.SPRING -> "it is spring"
        Seasons.SUMMER -> "it is summer"
        Seasons.AUTUMN -> "it is autumn.. or fall for you americans"
        Seasons.WINTER -> "it is winter"
    }
    println(str)

    // we can also use when without brackets
    val num3 = 10
    val num4 = 10
    when {
        num3 > num4 -> println("$num3 is greater than $num4")
        num3 < num4 -> println("$num3 is less then $num4")
        else -> println("$num3 is equal to $num4")
    }
}