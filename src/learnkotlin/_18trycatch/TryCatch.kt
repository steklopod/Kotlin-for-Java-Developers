package learnkotlin._18trycatch

fun main(args: Array<String>) {

    println(getNumber("22"))
    println(getNumber("22.5"))

    println(getNumberOrNull("15"))
    println(getNumberOrNull("NaN") ?: "I can't convert that")
}

// try catch can be used as an expression, just like the if statement
// the last line in the try and catch blocks is the return value
fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        return 0
    } finally {
        // even though println returns Unit, we get no error here!
        println("i'm in the finally block")
        // even though we can return a value from the finally block, it's essentially ignored
        1
    }
}

fun getNumberOrNull(str: String): Int? {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        null
    }
}

fun workInProgress(str: String): Nothing {
    throw IllegalArgumentException("i'm not implemented yet ")
}