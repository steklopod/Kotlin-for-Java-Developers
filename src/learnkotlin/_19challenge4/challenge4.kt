package learnkotlin._19challenge4

fun main(args: Array<String>) {

    // print number from 5 to 5000 in steps of 5
    for (i in 5..5000 step 5) println(i)

    // print from -500 to 0
    for (i in -500..0) println(i)

    // first 15 Fibonacci numbers using range in loop
    var lo = 0
    var hi = 1
    println(lo)
    println(hi)
    for (i in 1..13) {
        var total = lo + hi
        println(total)
        lo = hi
        hi = total
    }

    // print 1, 11, 100, 99, 98, 2 using breaks
    iLoop@ for (i in 1..5) {
        println(i)
        if (i == 2) break@iLoop
        for (j in 11..20) {
            println(j)
            for (k in 100 downTo 90) {
                println(k)
                if (k == 98) continue@iLoop
            }
        }
    }

    var num: Int = 44
    var dNum: Double = when {
        num > 100 -> -234.567
        num < 100 -> 444.555
        else -> 0.0
    }

    println(dNum)
}