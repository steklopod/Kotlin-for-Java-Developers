package learnkotlin._09functions

fun main(args: Array<String>) {
    // inline functions are not compiled at all, but rather the function body is inserted in the bytecode wherever they are called
    class someClass {
        inline fun someInlineFun() {
        }
    }
}