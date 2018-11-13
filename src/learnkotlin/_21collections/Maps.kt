package learnkotlin._21collections

fun main(args: Array<String>) {

    // type declaration <> is redundant, but aids clarity
    val immutableMapOfCars = mapOf<Int, Car>(1 to Car("blue", "WV", 1999),
            2 to Car("yellow", "opel", 1996),
            3 to Car("orange", "honda", 2001))
    // LinkedHashMap
    println(immutableMapOfCars.javaClass)
    println(immutableMapOfCars)

    val mutableMapOfCars = mutableMapOf<String, Car>("John" to Car("blue", "WV", 1999),
            "Pete" to Car("yellow", "opel", 1996),
            "Joe" to Car("orange", "honda", 2001))
    // also a LinkedHashMap
    println(mutableMapOfCars.javaClass)
    println(mutableMapOfCars)

    // If we want a HashMap we can ask for it specifically
    val hashMap = hashMapOf<Int, Car>(1 to Car("blue", "WV", 1999),
            2 to Car("yellow", "opel", 1996),
            3 to Car("orange", "honda", 2001))
    println(hashMap.javaClass)
    // hash maps are always going to be mutable. Notice the difference in syntax. If you try to use the 'to' keyword the
    // compiler will complain that it expects a Pair of <Int, Car>
    hashMap.put(4, Car("pink", "cadillac", 1955))

    // revisiting Pairs for a moment:
    val pair = Pair(10, "Ten")
    // unpacking a pair:
    val firstVal = pair.first
    val secondVal = pair.second
    // or the more concise equivalent. this is called destructuring declaration, which distributes the public variables
    val (first, second) = pair

    // going back to maps, if we want to iterate over elements in a map using this destructuring declaration
    for ((key, value) in hashMap) {
        println(key)
        println(value)
    }

    // both Pair and Map.entry implement what are called component functions.
    // we dont get them out of the box with normal classes, but they are simple to implement. Look at the Car class
    // in this package. We do get them with data classes though!
    val car = Car("orange", "240z", 1970)
    val (color, model, year) = car
}