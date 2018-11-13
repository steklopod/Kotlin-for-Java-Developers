package examples.kotlin

fun doSomething(name: String, number: Int = 0, address: String = "") {
    // ..
}

fun sayHello(name: String) {
    println("Hello $name!")
}

fun main(args: Array<String>) {
    sayHello("Jose")
}