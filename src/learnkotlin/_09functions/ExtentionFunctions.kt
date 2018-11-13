package learnkotlin._09functions

fun main(args: Array<String>) {
    println("some string with all lower case".upperFirstAndLast())
}

fun String.upperFirstAndLast(): String {
    // extension funtion: even though we dont own the string class, and we are not subclassing it, we can add functionality to it
    // 'this' is not even required, it'll work just fine without, but makes it clearer what is going on
    val upperFirst = this.substring(0, 1).toUpperCase()
    val upperLast = this.substring(this.length - 1).toUpperCase()
    return upperFirst + this.substring(1, this.length - 1) + upperLast
}