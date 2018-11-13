package learnkotlin._12enums

fun main(args: Array<String>) {

    println(Department.ACCOUNTING.getDepartmentInfo())
}
enum class Department(val fullName: String, val numEmployees: Int) {

    // one of the only places we need a semicolon is when adding a function to an enum class
    // after the last enum entry
    HR("Human Resources", 3),
    IT("Information Technology", 10),
    ACCOUNTING("Accounting", 4),
    SALES("Sales", 15);

    fun getDepartmentInfo() = "the $fullName department has $numEmployees employees"
}