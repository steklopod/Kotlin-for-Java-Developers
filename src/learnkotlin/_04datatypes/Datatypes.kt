package learnkotlin._04datatypes

import learnkotlin._00javacode.Dummyclass

fun main(args: Array<String>) {

    // no need to specify datatype if variable is initialized
    val intOne: Int
    val intTwo = 10

    // shorthand Java notation also works in Kotlin
    val longOne: Long
    var longTwo = 22L

    // type mismatch! even though Int fits inside Long, Kotlin will complain
    // longTwo = intTwo
    longTwo = intTwo.toLong()

    val byteOne: Byte = 111
    var shortOne: Short
    // again, type mismatch
    // shortOne = byteOne
    shortOne = byteOne.toShort()

    // Double is the default floating point data type
    var doubleOne = 65.432

    var floatOne = 65.432f
    println("this is a float: ${floatOne is Float}")
    doubleOne = floatOne.toDouble()

    val charOne = 'b'
    val charTwo: Char

    // you can't treat numbers like characters as you can in Java (i.e. refer to UTF-8 char 65 ('A') does not work)
    // var charThree: Char = 65
    val charInt = 65
    val charThree = charInt.toChar()
    println(charThree)

    val booleanOne: Boolean
    val booleanTwo = true

    val vacationTime = false
    // Java class in 'javacode' package expecting primitive boolean
    var onVacation = Dummyclass().isVacationTimePrimitive(vacationTime)
    // works fine even though vacationTime is a Boolean class
    println(onVacation)
    // But Java's unboxing also figures out if we expect a Boolean class
    onVacation = Dummyclass().isVacationTimeBoolean(vacationTime)
    println(onVacation)

    // the Any class is at the root of the class hierarchy
    val anything: Any

    // singleton Unit instance, sort of equivalent to 'void', except Kotlin returns an actual class
    val unit: Unit

    // no equivalence in Java. Subclass of every class, can be used anywhere you return a class
    // useful if a function is never expected to return
    val nothing: Nothing

    val names = arrayOf("John", "Pete", "Carl")

    val longsOne = arrayOf(1L, 2L, 3L)

    val longsTwo: Array<Long> = arrayOf(1, 2, 3)
    val longsThree = arrayOf<Long>(2, 3, 4)

    println(longsOne is Array<Long>)
    println(longsTwo is Array<Long>)
    println(longsThree is Array<Long>)

    val evenNumbers = Array(16) { i -> i * 2 }
    for (number in evenNumbers) {
        println(number)
    }

    val lotsOfNumbers = Array(100000) { i -> i }
    val lotsOfZeros = Array(100) { 0 }

    var someOtherArray: Array<Int>
    someOtherArray = arrayOf(1, 2, 4)
    someOtherArray = Array(10) { i -> i + 1 }

    for (number in someOtherArray) {
        println(number)
    }

    val someArray: Array<Int>
    someArray = Array(10) { i -> (i + 1) * 10 }
    // you can update the content of the array, but not the reference
    someArray[1] = 5000
    for (number in someArray)
        println("\t$number")

    val mixedArray = arrayOf("one", 2, 3.0, 4L, "v")
    for (elem in mixedArray) {
        println(elem)
    }
    println(mixedArray is Array<Any>)

    // this is Array<Int>
    val myArrayOfInts = arrayOf(1, 3, 4, 6)
    // this will cause a type mismatch
    // Dummyclass().printNumbers(myArrayOfInts)

    // instead we can use the intArrayOf class. This also has a performance boost to boot
    val myIntArray = intArrayOf(1, 2, 4, 5)
    Dummyclass().printNumbers(myIntArray)

    // another difference between Array<Int> and IntArray
    // this fails because we are calling the array constructor, which expects two aruments: size and values
    // var anotherArrayOfInt = Array<Int>(5)
    // but we can do it with IntArrays
    var anotherIntArray = IntArray(5)
    // it's initialized to all 0's
    for (number in anotherIntArray) {
        println(number)
    }

    // but we can also convert arrays
    Dummyclass().printNumbers(evenNumbers.toIntArray())

    // and the other way around
    val convertedArray: Array<Int> = myIntArray.toTypedArray()
}