package learnkotlin._23generics.declargitationsitevariance.contravariance

fun main(args: Array<String>) {

    // let's take a look at this example
    val roseGardener = object : Gardener<Rose> {
        override fun prune(flower: Rose) = println("I am pruning a rose")
    }

    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), roseGardener)
    roseGarden.tendFlower(0)

    val daffodilGardener = object :
        Gardener<Daffodil> {
        override fun prune(flower: Daffodil) = println("I am pruning a daffodil")
    }

    val daffodilGarden = Garden<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), daffodilGardener)
    daffodilGarden.tendFlower(1)

    // while the above code is valid, it is also pretty repetitive. It would be nice if we could use the same gardener
    // for each garden. this does not work though like this
    // In some sense, contravariance is the opposite of covariance. With covariance we are starting at a super-type and
    // want to accept all sub-types

    // Contravariance means we're starting with a sub-type, and we want to accept all super-types
    // so let's fix our little problem
    val flowerGardener = object :
        ContravariantGardener<Flower> {
        override fun prune(flower: Flower) = println("I prune ${flower.name}s in any garden!")
    }

    val daffodilGarden2 =
        ContravariantGarden<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), flowerGardener)

    daffodilGarden2.tendFlower(0)

    // just like with covariance, there is a price.. and it's in the name (of the keyword..)
    // Parameters in the 'in' position can be passed as arguments, but cannot be return types (again, the opposite
    // of covariance)
    // this is because if we were able to implement a 'pick' method in the gardener, we could not guarantee it's return
    // type. we would expect a rose from a rose garden, but because the gardener is generic, we have no guarantee that this
    // is really the case
}

class Garden<T : Flower>(val flowers: List<T>, val gardener: Gardener<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) = gardener.prune(flowers[i])
}

open class Flower(val name: String)

class Rose : Flower("Rose")

class Daffodil : Flower("Daffodil")

interface Gardener<T> {
    fun prune(flower: T)
}

// just like covariance uses the out-keyword, contravariance uses the in-keyword
interface ContravariantGardener<in T> {
    fun prune(flower: T)
    // as T is in the in position, we cannot use T as return type
    // fun pick: T
}

// This garden expects a different gardener type than the above garden
class ContravariantGarden<T : Flower>(val flowers: List<T>, val gardener: ContravariantGardener<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) = gardener.prune(flowers[i])
}