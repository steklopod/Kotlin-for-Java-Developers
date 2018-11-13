package learnkotlin._16ifexpression

fun main(args: Array<String>) {

    var num: Int

    // the java way
    if (true) {
        num = 50
    } else {
        num = 100
    }

    // we can shorten this to
    num = if (true) 50 else 100

    // so if statements can evaluate to a value
    // in fact the last statement in each block is the return value of the if-expression. If and else statements are
    // required:
    val num2 = if (10 > 20) {
        println("who would have thought")
        100
    } else {
        println("yeah, didn't think so")
        200
    }
    println(num2)

    // we can use it directly in the print statement for example:
    println(if (10 > 20) {
        println("who would have thought")
        100
    } else {
        println("yeah, didn't think so")
        200
    })

    // or in a string template:
    println("do you think 10 is greater than 20? ${if (10 > 20) {
        println("i did not expect that")
        100
    } else {
        println("ha.. i knew it")
        200
    }}")

    // we can assign the result of the if expression to a variable

    val x = if (true) {
        println("something")
    } else {
        println("something else")
    }
    // and the type of x is Unit. This is cool, but not really that useful
    println(x.javaClass)
}