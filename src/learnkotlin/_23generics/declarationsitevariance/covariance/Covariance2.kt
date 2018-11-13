package learnkotlin._23generics.declarationsitevariance.covariance

fun main(args: Array<String>) {
    val garden: Garden<Rose> = Garden()
    // this does NOT work
    // waterGarden(garden)

    val convRoseGarden = CovariantGarden<Rose>()
    tendCovariantGarden(convRoseGarden)
}

open class Flower

class Rose : Flower()

class Daisy : Flower()

class Garden<T : Flower> {
    // Garden is type-invariant
}

fun waterGarden(garden: Garden<Flower>) {
    // this will NOT accept a garden of Roses, even though Rose is a sub-type of Flower
}

fun tendGarden(garden: Garden<Rose>) {
    // this does NOT work! waterGarden accepts a Garden<Flower> ONLY, not any garden of sub types
    // waterGarden(garden)
}

class CovariantGarden<out T : Flower> {
    // using the out keyword, we can make the class covariant. However, similar to the mutable collections interface, we
    // are restricted in what we can do now. We cannot add anything to it, we can only use T in the 'out' position (hence
    // the out keyword) (the 'in' position is a function param, the 'out' the return type. So, we can only use T as return type

    // T now can be any kind of flower, and we will return whichever type of flower we have created the garden with
    val flowers: List<T> = listOf()
    fun pickFlowers(i: Int): T = flowers[i]

    // but we cannot add a new flower. (T is in the 'in' position here)
    // This is because we cannot make guarantees about the type of the function parameter that plantFlower is called with.
    // If We have a CovariantGarden<Rose>, the function could be called with a Daisy, since sub-typing would be preserved
    // so we could get into a situation where we have a mixed garden, even though it should only accept roses.
    // if something is covariant it must be impossible to change it, otherwise we arrive at this conundrum
    // fun plantFlower(flower: T)
}

fun waterCovariantGarden(garden: CovariantGarden<Flower>) {
    // This can now be called with any covariant garden, with any type of flower
}

fun tendCovariantGarden(garden: CovariantGarden<Rose>) {
    // and this can also be called with the Rose Garden
    waterCovariantGarden(garden)
}

// This works fine also, as something is a val of the same type, and immutable (Kotlin does not generate getters and
// setters under the hood
class GardenWithVal<out T : Flower>(val something: T)

// This does not though, as something is a var, and Kotlin generates a setter for it under the hood. So something could
// change about our class and we'd have the same problem again. The only way to avoid this is to declare something
// private, as this will shield it from the outside world
// class GardenWithVar<out T : Flower>(var something: T)