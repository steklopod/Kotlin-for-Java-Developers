package learnkotlin._21collections

fun main(args: Array<String>) {

    val seasons = listOf("Spring", "Summer", "Autumn", "Winter")
    val colors = listOf("red", "green", "blue")

    // last element
    println(seasons.last())
    // first element
    println(seasons.first())
    // inverted
    println(seasons.asReversed())
    // print element if it exists
    println(seasons.getOrNull(5))

    // creating pairs with vals from both lists. Winter is dropped as it remains unpaired
    println(seasons.zip(colors))

    // creates a list of two lists
    val mergedList = listOf(colors, seasons)
    println(mergedList)

    // to get a single list with both values it simply is
    val combinedList = colors + seasons
    println(combinedList)

    val duplicateMensNames = listOf("joe", "joe", "peter", "dave")
    val duplicateWomensNames = listOf("sue", "anne", "sue", "deb")

    // remove duplicate items when merging lists
    val noDupesList = duplicateMensNames.union(duplicateWomensNames)
    println(noDupesList)

    // distinct values in list
    println(duplicateMensNames.distinct())

    // max value in list
    val ints = listOf(1, 2, 3, 4)
    println(ints.max())

    // convert to mutable list
    val mutableInts = ints.toMutableList()
    mutableInts.add(5)
    println(mutableInts)
}