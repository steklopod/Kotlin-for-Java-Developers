package learnkotlin._08constructors

class Employee constructor(firstName: String) {
    // primary constructor example
    val firstName: String

    // init block is kind of the method body of the primary constructor
    init {
        this.firstName = firstName
    }
}

private class anotherEmployee constructor(firstName: String) {
    // same thing but shorter
    val firstName = firstName
}

class yetAnotherEmployee(val firstName: String) {
    // but even shorter
    // adding val keyword will create the class member and assign parameter
}

class soManyEmployees protected constructor(val firstName: String) {
    // we only need the constructor keyword if we want to change visibility
}

class Department(val name: String) {

    var fullTime: Boolean = true
    // delegating name assignment to primary constructor
    // but secondary constructors do not create members
    constructor(name: String, fullTime: Boolean): this(name) {
        this.fullTime = fullTime
    }
}

class AnotherDepartment(val name: String, var fullTime: Boolean = true) {
    // but the very short version of all of this is to just provide defaults in the primary constructor
}