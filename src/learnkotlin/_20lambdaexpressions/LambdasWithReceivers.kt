package learnkotlin._20lambdaexpressions

fun main(args: Array<String>) {

    println(countTo100UsingWith())
    println(countTo100UsingApply())

    val employees = listOf(Employee("John", "Smith", 2010),
        Employee("Joe", "Miller", 2005),
        Employee("Jane", "Anderson", 2000),
        Employee("Mike", "Ness", 2015)
    )

    findByLastName(employees, "Smith")
    findByLastName(employees, "Hudson")

    // using labels to get the right receiver object in nested apply methods
    // obvs naming the parameters is much better than labels
    "Some String".apply outer@{
        "Another String". apply {
            println(toLowerCase())
            println(this@outer.toUpperCase())
        }
    }
}

// with converts the instance you are passing to a receiver object, and inside the lambda we don't need to refer to the receiver
fun countTo100UsingWith() =
    with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append("100")
    }.toString()

// Using apply is similar to with, but apply returns the receiver object, that apply is called on (SB in this case
fun countTo100UsingApply() =
    StringBuilder().apply {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append("100")
        toString()
    }

// return in the lambda returns from both the lambda and the function if the calling funciton (forEach) is inlined
// this is called a non-local return
// we can use labels to modify this behaviour. Again, this can get sticky quickly like in this example right here
fun findByLastName(employees: List<Employee>, key: String) {
    employees.forEach returnBlock@{
        if (it.lastName == key) {
            println("yes, there is an employee with the last name $key")
            return@returnBlock
        }
    }
    println("nope, there is no employee with the last name $key")
}