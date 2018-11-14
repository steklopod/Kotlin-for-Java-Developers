package _13packages._01mainSubPackage

// imports of interfaces and classes work same as in Java
// but what about top level functions?
// we just specify the name of the function just like we would with a class

// if we add another module as dependency, we can also import from there!
//TODO - раскомментировать и разобраться с импортом
//import thisis.justanother.module.fordemo.purposes.topLevelFunctionFromAnotherModule

// we can import objects in the same way

// same for enums. We can import single enums or all of them with *

// we can also rename imports; and also upperFirstAndLast is an extension function ;)
import _11Objects.PrinterCopyrightNotice
import _12enums.Department.ACCOUNTING
import _13packages._02otherSubPackage.topLevelFunction
import _09functions.upperFirstAndLast as transform

// again, private means visible from the same file only
private fun privateTopLevelFun() = "i'm private to this file"

// and internal means internal to the module
internal fun internalTopLevelFun() = "i am internal to this module"
// try to import those in different files and modules!

fun main(args: Array<String>) {
    println(topLevelFunction("Hello from another file"))
//    println(topLevelFunctionFromAnotherModule("I'm in another module"))
    println(PrinterCopyrightNotice.getCopyRightNotice())
    println(ACCOUNTING.getDepartmentInfo())
    println("somestring".transform())
    println(privateTopLevelFun())
    println(internalTopLevelFun())
}