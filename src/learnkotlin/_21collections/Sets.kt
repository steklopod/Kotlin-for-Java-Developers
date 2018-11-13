package learnkotlin._21collections

fun main(args: Array<String>) {

    // LinkedHashSet is the default set
    val setOfInts = setOf(1, 2, 3, 3, 4)
    println(setOfInts.javaClass)
    println(setOfInts)

    // also a LinkedHashSet
    val mutableSetOfInts = mutableSetOf(1, 2, 3, 3, 4)
    println(mutableSetOfInts.javaClass)
    println(mutableSetOfInts)

    // specific set types
    val hashSet = hashSetOf(1, 2, 3, 3, 4)
    println(hashSet.javaClass)
    val linkedSet = linkedSetOf(1, 2, 3, 3, 4)
    println(linkedSet.javaClass)
    val sortedSet = sortedSetOf(1, 4, 3, 3, 2)
    println(sortedSet.javaClass)

    // adding element to a set
    println(setOfInts.plus(20))
    // removing from set
    println(setOfInts.minus(4))
    // actually, we're not really adding or removing anything because this set is immutable. we're not assigning the
    // result, only printing it

    // average
    println(setOfInts.average())

    // drop the first n elements from the set
    println(setOfInts.drop(2))

    // looking at mutable sets
    val mutableInts = mutableSetOfInts
    mutableInts.plus(6)
    // even though the set is mutable we dont change it with the plus function! Instead it returns a result!
    println(mutableInts)
}