@file:JvmName("KotlinCar")

package learnkotlin._26javainteroperability.kotlinfromjava

import java.io.IOException

fun topLevel() = println("I'm a top level function")

object SingletonCar {
    fun doCarWhatACarDoes() = println("wroom wroom")
}

class Car(val name: String, val color: String, @JvmField val year: Int, var isAutomatic: Boolean) {

    companion object {
        fun carComp() = println("i'm in car's companion object")

        @JvmStatic
        fun staticCarComp() = println("i'm static and in car's companion object")

        @JvmField
        val isAuto = false

        const val constant = 25
    }

    fun printMe(text: String) {
        println("I dont expect a null value")
    }

    @Throws(IOException::class)
    fun throwIOException() {
        throw IOException("well this is embarrassing")
    }

    @JvmOverloads
    fun defaultArgs(s: String, int: Int = 25) {
    }
}

fun Car.print() = println("print the car")