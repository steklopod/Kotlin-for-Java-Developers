package learnkotlin._23generics

fun main(args: Array<String>) {

    val shorts: List<Short> = listOf(10, 20, 30, 40)
    val floats: List<Float> = listOf(1.23f, 2.34f, 3.45f, 4.56f, 5.99f)

    convertToInt(shorts)
    convertToInt(floats)

    append(StringBuilder("String 1"), StringBuilder("String 2"))

    val nullableList: List<Int?> = listOf(1, 2, 3, null, 4)
    noUpperBound(nullableList)

    nonNullableTypesOnly(floats)

    // in Java, generics are a compile time feature (type erasure - the JVM knows an object is a List for example,
    // but even if we specify it, it does not know if it is a List<String> for example
    // the same is true for Kotlin (it runs on the same JVM after all
    // but this works as it can be figured out at compile time that it is always true as type parameters are enforced
    if (shorts is List<Short>) println("this list contains shorts")

    // this check cannot be performed as the compiler cannot make guarantees at compile time and this check has to be
    // performed a run time. Since types are erased, this is impossible
    val anyList: List<Any> = listOf("str1", "str2")
    // if (anyList is List<String>) println("this list contains strings")

    // So to check if something is a List we have to use (star projection)
    if (anyList is List<*>) println("this is a list")

    // this could go wrong as WE know that we have a list of strings, but the compiler cannot be sure of this
    // if we do this with a list of Int, we will get an exception, and a compiler warning
    if (anyList is List<*>) {
        println("we have a list")
        val stringList = anyList as List<String>
        println(stringList[0].replace("str", "string"))
    }
}

// as there is no guarantee that T has the toInt function, we can set an upper bound of accepting any sub class
// of Number (which defines the toInt method for all numeric types)
fun <T : Number> convertToInt(collection: List<T>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
}

// we can specify several upper bounds with where. We can have only one class (no multiple inheritance) but many interfaces
fun <T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable {
    println("result is ${item1.append(item2)}")
}

// T is the 'nullable' T, so we can pass nullable types to our function if we don't specify an upper bound
fun <T> noUpperBound(collection: List<T>) {
    for (item in collection)
        println("${item ?: "i was null all along"}")
}

// to accept only non-nmullable types, we do the same as with Number, just use Any:
fun <T : Any> nonNullableTypesOnly(collection: List<T>) {
    for (item in collection) println(item)
}