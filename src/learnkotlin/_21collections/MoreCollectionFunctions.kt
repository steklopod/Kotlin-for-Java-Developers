package learnkotlin._21collections

fun main(args: Array<String>) {

    // some data to work with
    val setInts = setOf<Int>(1, 2, 3, 3, 4, 5, 6, 6, 6, 7, 9, 8)
    val immutableMapCars = mapOf<Int, VintageCar>(
        1 to VintageCar("blue", "detommaso", 1967),
        2 to VintageCar("yellow", "challenger", 1971),
        3 to VintageCar("orange", "firebird", 1973))
    val mutableMapCars = mutableMapOf<Int, VintageCar>(
        3 to VintageCar("green", "barracuda", 1975),
        5 to VintageCar("purple", "fair lady", 1976),
        1 to VintageCar("green", "detommaso", 1967),
        4 to VintageCar("orange", "firebird", 1973),
        6 to VintageCar("orange", "challenger", 1971),
        2 to VintageCar("black", "e30", 1988)
    )
    val intArray = arrayOf(1, 2, 3, 4, 5)
    val carList = mutableMapCars.values

    // filter function returns a new instance, so none of the data is modified
    println(setInts.filter { it % 2 != 0 })
    println(immutableMapCars.filter { it.value.year > 1970 })
    println(mutableMapCars.filter { it.value.color == "orange" })

    // map performs the same action for each item in a collection
    val add10List = intArray.map { it + 10 }
    println(add10List)

    val carYears = mutableMapCars.map { it.value.year }
    println(carYears)

    // chain filter and map
    val carsAfter1973 = mutableMapCars
        .filter { it.value.year > 1972 }
        .map { it }
    println(carsAfter1973)

    // all function returns bool if the lambda condition is met for all elements
    val allCarsAreVintage = mutableMapCars.all { it.value.year < 1979 }
    println(allCarsAreVintage)

    // any function returns bool if the lambda condition is met for any element
    val anyCarIsModern = mutableMapCars.any { it.value.year < 1979 }
    println(anyCarIsModern)

    // count function returns count of items matching the lambda condition
    val numberVintageCars = mutableMapCars.count { it.value.year < 1979 }
    println(numberVintageCars)

    // for lists, we can use the find function to find the first item that matches
    println(carList.find { it.year < 1976 })

    // group by creates a map with the group by condition as key
    println(carList.groupBy { it.color })

    // sort items in map or list
    println(mutableMapCars.toSortedMap())
    println(carList.sortedBy { it.year })
}

data class VintageCar(val color: String, val model: String, val year: Int)