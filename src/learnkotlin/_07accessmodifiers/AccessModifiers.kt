package learnkotlin._07accessmodifiers

import learnkotlin._08constructors.AnotherDepartment
import learnkotlin._08constructors.Department
import learnkotlin._08constructors.Employee
import learnkotlin._08constructors.SecondaryConstructorOnly

val MY_CONSTANT = 100

fun main(args: Array<String>) {

    // default visibility is 'public' unlike java
    // no matching requirement for public class and file name either
    // we can also have private classes, which means it can only be accessed from the same file
    val emp = Employee(firstName = "John")
    println(emp.firstName)

    val department = Department(name = "IT")
    department.fullTime
    val department2 = Department(name = "Finanace", fullTime = false)

    // using the shorter declaration
    val dept1 = AnotherDepartment(name = "Bla")
    val dept2 = AnotherDepartment(name = "BlaBla", fullTime = false)

    println(SecondaryConstructorOnly().dummy)

    val privateClassInstance = ClassWithPrivateMembers(name = "Hans")
    // privateClassInstance.name

    val customGetter = ClassWithCustomGetterAndSetters()
    println(customGetter.name)
    customGetter.name = "Jane Doe"
    println(customGetter.name)

    println(MY_CONSTANT)

    // Car is a data class
    val car = Car("blue", "Toyota", 2015)
    // data classes have a nice in built toString method
    println(car.toString())
    // and also a different implementation of the equals method that checks for structural equivalence and NOT referential
    val car2 = Car("blue", "Toyota", 2015)
    println(car == car2)
    // also we get a copy method for free
    val car3 = car2.copy()
    println(car3)
    // and we can override specific parameters
    val car4 = car3.copy(year = 2016)
    println(car4)
}