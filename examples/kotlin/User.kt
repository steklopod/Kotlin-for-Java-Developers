package examples.kotlin

data class User(val name: String, var age: Int)

fun main(args: Array<String>) {
    var user = User("Jose", age = 32)
    user.age = 33
    // user.name = "Ana" This is wrong, name property is inmutable!
}