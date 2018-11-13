package learnkotlin._09functions

fun main(args: Array<String>) {
    println(labelledMultiply(3, 4))
    println(simplifiedLabelledMultiply(9, 4, "The result is:"))
    // if you name one argument, all of them must be named
    println(simplifiedLabelledMultiply(label = "Here's the result:", operand2 = 4, operand1 = 6))
    // this can be useful if you have functions with lots of params. Self documenting code!
    println(functionWithLotsOfArgs(height = 3,
        width = 4,
        depth = 5,
        weight = 12))

    // class functions
    val emp1 = Employee("jane")
    println(emp1.uppercaseFirstName())
    val emp2 = Employee("joe")
    val emp3 = Employee("john")
    printEmployeeNamesInUppercase(emp1, emp2, emp3)

    val employeeList = arrayOf(emp1, emp2, emp3)
    // this would work in J ava, but not in Kotlin:
    // printEmployeeNamesInUppercase(employeeList)
    // so we can use the spread-operator to unpack the array
    printEmployeeNamesInUppercase(*employeeList)
    // we can use this for example to
    val anotherEmployeeList = arrayOf(emp1, emp2, emp3)
    val fullEmployeeList = arrayOf(emp1, *employeeList, *anotherEmployeeList)
    for (emp in fullEmployeeList) {
        println(emp)
    }
}

// default return type is Unit, unless specified.
// this is redundant:
// fun redundantReturnType(args: Array<String>): Unit { }

// simple function with block body and default param. Function param defaults require the type
fun labelledMultiply(operand1: Int, operand2: Int, label: String = "The answer is:"): String {
    return ("$label ${operand1 * operand2}")
}

// one line function with expression body that returns whatever follows the = sign, the compiler can infer the return type
// even the main function could have an expression body
fun simplifiedLabelledMultiply(operand1: Int, operand2: Int, label: String) =
    "$label ${operand1 * operand2}"

// this isn't going to work bc return type mismatch, found Int, required Unit
// fun notWorkingExample(): Unit = 3 * 4

fun functionWithLotsOfArgs(height: Int, width: Int, depth: Int, weight: Int): Int {
    return (height * width * depth * weight)
}

data class Employee(val firstName: String) {
    // public and final by default
    fun uppercaseFirstName() = firstName.toUpperCase()
}

fun printEmployeeNamesInUppercase(vararg employees: Employee) {
    // vararg should be the last argument in the function signature
    // otherwise we have to use names parameter in the function call to let the compiler know which params are part of
    // the vararg and which of the regular function params
    for (employee in employees) {
        println(employee.uppercaseFirstName())
    }
}