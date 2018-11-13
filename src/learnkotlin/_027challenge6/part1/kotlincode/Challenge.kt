package learnkotlin._027challenge6.part1.kotlincode

import learnkotlin._027challenge6.part1.javacode.Employee

fun main(args: Array<String>) {

    val employee = Employee("Jane", "Smith", 2000)

    // Make this code compile
    employee.lastName = "Jones"
    employee.salaryLast3Years = floatArrayOf(50000.25F, 54000.60F, 56800.42F)
}