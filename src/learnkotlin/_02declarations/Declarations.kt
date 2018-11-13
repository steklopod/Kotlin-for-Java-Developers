package learnkotlin._02declarations

fun main(args: Array<String>) {
    val number = 25
    val number2: Int
    number2 = 10
    // number2 = 33 does not work as vals cannot be assigned, like 'final' in Java
    val number3: Int = 25 // rarely used

    var number4 = 20
    var number5: Int
    number5 = 20
    number5 = 30
    var number6: Int = 44 // rarely used

    val employee1 = Employee(id = 1, name = "Lynn")
    val employee2 = Employee("Joe", 1)
    employee1.name = "Sally" // var instance properties are mutable even if the instance is a 'val'
    // employee1 = Employee("asd", 3) this does not work

    // indexing into  arrayList works like array
    val names = arrayListOf("Hans", "John", "Al ")
    println(names[1])

    val employee3 = Employee("Joe", 1)
    val employee4 = Employee("Pete", 2)
    val employee5 = Employee("Pete", 2)

    println(employee3 == employee4) // false
    println(employee4 == employee5) // true, unlike java
    println(employee3.equals(employee4)) // false
    println(employee4.equals(employee5)) // true
    // '==' uses the .equals method under the hood, so the implementation is redundant
    // check for referential equality:
    val employee6 = employee5
    println(employee3 === employee4) // false
    println(employee6 === employee5) // true

    println(employee3 != employee4) // true
    println(employee4 != employee5) // false
    println(employee3 !== employee4) // true
    println(employee6 !== employee5) // false

    // type checking and casting
    val something: Any = employee4
    if (something is Employee) {
        // after a type check, kotlin will have figured out the type of 'something' already and we can refer
        // to the class members. Feature called 'smart casting'
        something.name
    }
    if (something !is Employee) {
        // something else
    }

    val newEmployee = something as Employee

    println(newEmployee)

    val change = 4.22
    println("change: $change")
    println("but we can escape the dollar sign: \$change")
    println("and kotlin can also infer the string substition: $$change ")

    val numerator = 10.99
    val denominator = 20.00
    println("the value of $numerator divided by $denominator is: ${numerator / denominator}")

    println("The employeeOne's id is: ${employee1.id}")
    println("but this is part of the string: $employee1.id ")

    // raw string
    // val filePathString = "c:\asd" this is n ot working as the backslash is not escaped
    val filePathString = "c:\\asd\\asd" // need to escape the backslash
    val filePathRawString = """c:\asd\asd""" // or use a raw string

    val str = "string"
    val longString = """this is a really
        *long $str that is
        *broken over many lines
        *but with trim margin it can be indented even though
        *it is aware of          whitespace
    """.trimMargin("*") // if no trim character is supplied, | (pipe) is the default
    println(longString)
}

class Employee(var name: String, val id: Int) {

    override fun equals(obj: Any?): Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }
        return false
    }

    override fun toString(): String {
        return "employee: name=$name, id=$id"
    }
}