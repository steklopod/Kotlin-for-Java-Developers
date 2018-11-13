package learnkotlin._11Objects

// Object Expressions are similar to annonymous classes in Java

fun main(args: Array<String>) {

    // even though we use the object keyword, this is not a singleton. the object is used once and the ndiscarded
    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int): String = "this is from an annonymous objects mustImplement method: ${num * 100}"
    })

    // unlike java, we can access non-final local var's outside the annonymous declaration:
    var nonFinalVar = 45
    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int): String {
            nonFinalVar++
            return "shpwing you that i can increment things outside of my declaration"
        }
    })
    println(nonFinalVar)
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("printing from SomeInterfaces method: ${si.mustImplement(5)}")
}
