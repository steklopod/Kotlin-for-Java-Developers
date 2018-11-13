package learnkotlin._23generics.usesitevariance

fun main(args: Array<String>) {

    // this works great, except it will only work with Cars (remember the difference in the Mutable and Immutable
    // interfaces
    val cars = mutableListOf(Car(), Car())
    val cars2: MutableList<Car> = mutableListOf()
    simpleCopyCars(cars, cars2)
    println(cars2)

    // now we could the generic function and it does work
    val fords = mutableListOf(Ford(), Ford())
    val fords2 = mutableListOf(Ford(), Ford())
    genericCopyCars(fords, fords2)

    // however, we cannot do this. Both T's have to be the same
    // genericCopyCars(fords, cars2)

    // this is not great because we are able to do this
    val cars3: MutableList<Car> = mutableListOf(Ford(), Ford())

    // but if we look closer at the function, we only ever read the source, and write the destinatino.. this
    // sounds a lot like the restrictions around covariance and contravariance. And this indeed works. This is called
    // use-site variance or type projection
    typeProjectionCopyCars(fords, cars)
}

fun simpleCopyCars(source: MutableList<Car>, destination: MutableList<Car>) {
    destination.addAll(source)
}

fun <T> genericCopyCars(source: MutableList<T>, destination: MutableList<T>) {
    destination.addAll(source)
}

fun <T> typeProjectionCopyCars(source: MutableList<out T>, destination: MutableList<T>) {
    destination.addAll(source)
}

open class Car

open class Ford : Car()

open class DeTommaso : Car()
