package learnkotlin._03challenge1

fun main(args: Array<String>) {
    val hello1: String = "Hello"
    val hello2 = "Hello"

    println("hello1 is referentially equal to hello2: ${hello1 === hello2}")

    println("hello1 is structually equal to hello2: ${hello1 == hello2}")

    var number: Int = 2986

    val sth: Any = "The any type is the root of the Kotlin hierarchy"

    if (sth is String) {
        println(sth.toUpperCase())
    }

    println("""   1
        |  11
        | 111
         |1111""".trimMargin())

    println("""1   1
        1  11
        1 111
        11111
    """.trimMargin("1"))
}