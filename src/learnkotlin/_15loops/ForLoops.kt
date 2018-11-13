package learnkotlin._15loops

fun main(args: Array<String>) {

    // while and do-while loops have not changed
    // for loops have, and operate on ranges

    // the range operator is .. and 1 and 5 are inclusive
    val range = 1..5
    // we can cast ranges of anything that is comparable
    val charRange = 'a'..'z'
    val stringRange = "abc".."xyz"

    println(3 in range)
    println('q' in charRange)
    println("ccc" in stringRange)
    println("cccccc" in stringRange)
    println("zzzzzz" in stringRange)

    // to create ranges in reverse order we must use the .downTo() method
    val revRange = 5.downTo(1)

    // if we want a range with every third number for example
    val upToThirty = 1..30
    val multiplesOfThree = upToThirty.step(3)

    // and we can reverse the range with
    val reversedMultipes = multiplesOfThree.reversed()

    // now the foor loop
    for (i in reversedMultipes) {
        println(i)
    }

    // we can also declare the range in the loop
    for (i in 1..5) {
        println(i)
    }
    // and use the step function
    for (i in 1..20 step 3)
        println(i)

    // reverse order and steps
    for (i in 20 downTo 15 step 2)
        println(i)

    // if we dont want to include the last val in the range (as with the .. operator) we can use until
    for (i in 0 until 10)
        println(i)

    // string ranges have no iterator method and can't be used in loops
    // but we can loop over chars in strings
    val str = "hello"
    for (c in str) {
        println(c)
    }

    // looping over arrays
    val seasons = arrayOf("Spring", "Summer", "Autumn", "Winter")
    for (season in seasons)
        println(season)

    // another way
    for (index in seasons.indices)
        println("season ${seasons[index]} is season number $index")

    // as a lambda
    seasons.forEach { println(it) }
    seasons.forEachIndexed { index, value -> println("$index - $value") }

    // named loops works with break and continue
    // this tends to get messy quickly though
    for (i in 1..10) {
        println("i = $i")
        jloop@ for (j in 1..10) {
            println("j = $j")
            for (k in 1..10) {
                println("k = $k")
                if (k == 4)
                    break@jloop
            }
        }
    }
}