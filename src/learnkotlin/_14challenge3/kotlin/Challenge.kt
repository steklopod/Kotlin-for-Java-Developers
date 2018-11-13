package learnkotlin._14challenge3.kotlin

fun main(args: Array<String>) {

    val kotlinBicycle = KotlinBicycle(3, 15, 7)
    kotlinBicycle.printDescription()

    val kotlinMountainBike = KotlinMountainBike(3, 15, 20, 21)
    kotlinMountainBike.printDescription()

    val kotlinRoadBike = KotlinRoadBike(21, 5, 30, 20)
    kotlinRoadBike.printDescription()

    val kotlinBicycle2 = KotlinBicycle(3, 15)
    kotlinBicycle2.printDescription()

    val kotlinMountainBike2 = KotlinMountainBike(3, 15, 20)
    kotlinMountainBike2.printDescription()

    val kotlinRoadBike2 = KotlinRoadBike(21, 5, 30)
    kotlinRoadBike2.printDescription()

    val kotlinMountainBike3 = KotlinMountainBike("green", 3, 19, 29, 9)
    kotlinMountainBike3.printDescription()

    println(KotlinMountainBike.availableColors)
}

open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) = {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in $gear gear with a cadence of $cadence and  travelling at the speed of $speed!")
    }
}

class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10) : KotlinBicycle(cadence, speed, gear) {

    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int): this(seatHeight, cadence, speed, gear) {
        println(color)
    }

    companion object {
        val availableColors: List<String> = arrayListOf("blue", "green", "white", "black")
    }
    override fun printDescription() {
        super.printDescription()
        println("The mountainbike has a seat height of $seatHeight.")
    }
}

class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 10) : KotlinBicycle(cadence, speed, gear) {
    override fun printDescription() {
        super.printDescription()
        println("The roadbike has a tire width of $tireWidth. ")
    }
}