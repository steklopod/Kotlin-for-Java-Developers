package learnkotlin._22sequences

fun main(args: Array<String>) {

    // chaining function calls creates an intermediate collection at each step
    // sequences are useful if dealing with large collections, or the result of a DB query with unknown number of results
    // sequences are similar to streams in java, and reimplemented in Kotlin as not all platforms support them
    // entries in a sequence can be enumerated one by one and evaluated individually instead of the entire
    // collection being evaluated at each step

    val mutableMapCars = mutableMapOf<Int, VintageCar>(
        3 to VintageCar("green", "barracuda", 1975),
        5 to VintageCar("purple", "fair lady", 1976),
        1 to VintageCar("green", "detommaso", 1967),
        4 to VintageCar("orange", "firebird", 1973),
        6 to VintageCar("orange", "challenger", 1971),
        2 to VintageCar("black", "e30", 1988)
    )
    // using as sequence is as simple as calling asSequence. However, we are not getting a list back
    // sequences are evaluated lazily, only when a 'terminal' operator is called, an 'intermediate'
    // operator returns a sequence. In this case we want a list, so we call the terminal toList operator
    println(mutableMapCars
        .asSequence()
        .filter { println("filtering $it"); it.value.color == "green" }
        .map { println("mapping $it"); it.value.model }
        .toList()
    )
    // this can be really useful with the find operator for example, as the whole chain will terminate as soon
    // as find finds a match. 'Leonardo' will never be checked, as we find a result in Greg
    // without the call to asSequence, all items in the list will be filtered and mapped.
    println(listOf<String>("Peter", "Greg", "Leonardo")
        .asSequence()
        .filter { println("Filtering uppercase first letter: $it"); it[0].isUpperCase() }
        .map { println("mapping $it to uppercase: "); it.toUpperCase() }
        .find { println("finding last letter 'G' in $it: "); it.endsWith("G") }
    )
}

data class VintageCar(val color: String, val model: String, val year: Int)