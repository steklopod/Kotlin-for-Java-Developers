package learnkotlin._07accessmodifiers

class ClassWithPrivateMembers(private val name: String) {
    // class with private members
    // there is no way to generate a public getter / setter for the name property.
    // private means really private to the class
    // any getter or setter has to have the same or less permissive access modifier
    // but actually, any call to change a class property uses a getter / setter under the hood!! (this means we can write our own as well)
}