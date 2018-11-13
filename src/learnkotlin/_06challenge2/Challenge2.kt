package learnkotlin._06challenge2

fun main(args: Array<String>) {

    // 1
    var float1: Float = -3684.234f
    var float2 = -3684.234f

    // 2
    var float3: Float? = -3684.234F

    // 3
    val shortArray = shortArrayOf(1, 2, 3, 4, 5)
    val shortArray2: Array<Short> = arrayOf(1, 2, 3, 4, 5)

    // 4
    val nullableIntArray: Array<Int?> = Array(40) { i -> (i + 1) * 5 }
    val nullableIntArray2 = Array<Int?>(40) { i -> (i + 1) * 5 }

    // 5
    val charArray2 = charArrayOf('a', 'b', 'c')
    // you would not be able to pass this to the Java method:
    // val charArray: Array<Char> = arrayOf('a', 'b', 'c')

    // 6
    val x: String? = "I AM UPPERCASE"
    val y: String = x?.toLowerCase() ?: "I give up"

    // 7
    val z = x?.let { it.toLowerCase().replace("am", "am not") }
    println(z)

    // 8
    val myNonNullVariable: Int? = null
    myNonNullVariable!!.toDouble()
}