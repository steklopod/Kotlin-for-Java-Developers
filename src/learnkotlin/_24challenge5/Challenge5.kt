package learnkotlin._24challenge5

fun main(args: Array<String>) {

    val joe = Person("Joe", "Jones", 45)
    val (fName, lName, age) = joe

    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 66)

    val persons = mapOf(
        joe.lastName to joe,
        jane.lastName to jane,
        mary.lastName to mary,
        john.lastName to john,
        jean.lastName to jean
    )
    println(persons
        .filter { it.value.lastName.startsWith("S") }
        .count()
    )

    // approach 1
    val namePairs1 = persons.map { Pair(it.value.firstName, it.value.lastName) }
    println(namePairs1)

    // approach2
    val firstNames = persons.map { it.value.firstName }
    val lastNames = persons.map { it.value.lastName }
    val namePairs2 = firstNames.zip(lastNames)
    println(namePairs2)

    persons.also {
        it.map { println("${it.value.firstName} is ${it.value.age} years old") }
    }

    val list1 = listOf(1, 4, 9, 15, 33)
    val list2 = listOf(4, 55, -83, 22, 15, 101)

    // approach 1
    val list3 = list1.filter { it in list2 }
    println(list3)

    // approach 2
    val list4 = list1.filter { list2.contains(it) }
    println(list4)

    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper
}

class Person(val firstName: String, val lastName: String, val age: Int) {
    operator fun component1() = this.firstName
    operator fun component2() = this.lastName
    operator fun component3() = this.age
}

class Box<out T>

open class Paper

class Regular : Paper()

class Premium : Paper()
