package learnkotlin._10inheritance

interface MyInterface {

    fun myInterfacesFunction(str: String): String

    // interfaces can have properties
    val number: Int
    val numberTimes100: Int
        get() = number * 100
}

interface MySubInterface : MyInterface {
    fun mySubinterfacesFunction(str: String): String
}

open class SuperClass(val sth: String)

class SubClass : SuperClass("asd"), MySubInterface {

    // we need to override the interface property here because it is not a concrete property in the interface
    override val number: Int = 25
    // but we can still override the implementation from the interface
    override val numberTimes100 = 44

    override fun myInterfacesFunction(str: String): String = "Not implemented"

    override fun mySubinterfacesFunction(str: String): String = "Also not implemented"
}

fun main(args: Array<String>) {
    println(SubClass().number)
    println(SubClass().numberTimes100)
}