package learnkotlin._11Objects

fun main(args: Array<String>) {
    // we don't really have statics in kotlin, so in order to be able to access fields without creating an instance
    // of a class we can use the companion object
    println(SomeClass.accessPrivateVar())
    // this won't work though because we have no instance of SomeClass
    // println(SomeClass.accessSomeVar())

    val someInstance = SomeClass.factoryUpperOrLower("Well hello there", false)
    println(someInstance.someString)
    val someOtherInstance = SomeClass.factoryJustAssign("welcome")
    println(someOtherInstance.accessSomeVar())

    // with the private primary constructor, we cannot do this anymore
    // SomeClass("someString")
}

class SomeClass private constructor(val someString: String) {

    // this is not accessible without instance
    fun accessSomeVar() = "$someVar"
    var someVar = 66

    companion object {
        // think of things in the companion object to be static
        private var privateVar = 6
        fun accessPrivateVar() = "I'm accessing private var: $privateVar"

        // we can also use the companion object to implement the factory pattern
        // rather than having a bunch of different secondary constructors
        // to make sure the only way to create instances of this class is through the factory, we add also the
        // private constructor keywords to the class declaration
        fun factoryJustAssign(str: String) = SomeClass(str)
        fun factoryUpperOrLower(str: String, lowerCase: Boolean): SomeClass {
            if (lowerCase) return SomeClass(str.toLowerCase())
            else return SomeClass(str.toUpperCase())
        }
    }
}