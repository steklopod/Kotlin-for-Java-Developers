package learnkotlin._23generics

import java.math.BigDecimal

fun main(args: Array<String>) {

    // unlike Java, we need a type when declaring a list / array list without entries (or initialize it for the compiler
    // to infer the type)
    val list: MutableList<String> = mutableListOf("Hello")
    list.add("World")
    printCollection(list)

    val bdList: MutableList<BigDecimal> = mutableListOf(
        BigDecimal(345.678),
        BigDecimal(555.444),
        BigDecimal(1234.5678),
        BigDecimal(0.1)
    )
    bdList.printAll()
}

fun <T> printCollection(collection: List<T>) {
    for (item in collection) println(item)
}

// or as extension function
fun <T> List<T>.printAll() {
    for (item in this) println(item)
}