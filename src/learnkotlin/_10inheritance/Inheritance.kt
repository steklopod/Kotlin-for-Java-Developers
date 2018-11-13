package learnkotlin._10inheritance

fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("epson")
    laserPrinter.printModel()
    println(laserPrinter.bestSellingPrice())

    SubclassOfClassWithoutPrimaryConstructor(10)
}

abstract class Printer(val modelName: String) {
    // 'normal' classes are final by default
    // 'open' classes can be inherited from
    // 'abstract' classes are open by default. otherwise, what's the point?

    // similarly, functions are final by default, so must be declared open to be overridden
    open fun printModel() = println("the model name is $modelName")

    // abstract function must be implemented by the subclass
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(modelName: String) : Printer(modelName) {
    // class extending Printer using the default primary constructor (remember the ()'s)

    // add override keyword to override implementation of super class
    // otherwise we would create two functions with the same signature
    override fun printModel() = println("the model name of this laser printer is $modelName")

    // abstract function defined in the super class must be implemented in the sub class with override keyword
    // final prevents us from overriding this method in any subclass (like MultiFunctionLaserPrinter
    final override fun bestSellingPrice(): Double = 129.99
}

class MultiFunctionLaserPrinter(modelName: String) : LaserPrinter(modelName) {

    override fun printModel() = println("the model of that MultiFunctinLasterPrinter is $modelName")
    // cannot override bestSellingPrive because it is final
    // override fun bestSellingPrice(): Double = 129.99
}

open class ClassWithoutPrimaryConstructor {

    val someProperty: Int

    constructor(param: Int) {
        someProperty = param
        println("im the superclass constructor")
    }
}

class SubclassOfClassWithoutPrimaryConstructor : ClassWithoutPrimaryConstructor {

    // every secondary constructor delegates to the primary constructor
    // we can only explicitly call the secondary constructor of the super class if it does not have a primary constructor
    constructor(param: Int) : super(param) {
        println("im the subclass constructor")
    }
}
// data classes cannot be extended
// open data class DataClassParent(val x: Int) { }
