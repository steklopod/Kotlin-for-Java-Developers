package learnkotlin._23generics

import java.math.BigDecimal

fun main(args: Array<String>) {
    // because generics are erased at runtime, when a function accepts a parameter with a generic type, there is no way
    // to determine at runtime which type it was invoked with
    val mixedList: List<Any> = listOf(
        1,
        2,
        "3",
        "4",
        BigDecimal(5),
        BigDecimal(6),
        7f
    )
    val bigDecimalsOnly = getElementsOfType<BigDecimal>(mixedList)
    println(bigDecimalsOnly)
    val stringsOnly = getElementsOfType<String>(mixedList)
    println(stringsOnly)
}

// ..unless we use an inline function with the reified keyword
// this is the only use of the reified keyword (in inline functions to check the generic type)
inline fun <reified T> getElementsOfType(collection: List<Any>): List<T> {
    var newList: MutableList<T> = mutableListOf()
    for (element in collection) {
        if (element is T) {
            newList.add(element)
        }
    }
    return newList
}