package learnkotlin._13packages._01mainSubPackage

// imports of interfaces and classes work same as in Java
// but what about top level functions?
// we just specify the name of the function just like we would with a class
import learnkotlin._13packages._02otherSubPackage.topLevelFunction

// if we add another module as dependency, we can also import from there!
import thisis.justanother.module.fordemo.purposes.topLevelFunctionFromAnotherModule

// we can import objects in the same way
import learnkotlin._11Objects.PrinterCopyrightNotice

// same for enums. We can import single enums or all of them with *
import learnkotlin._12enums.Department.ACCOUNTING

// we can also rename imports; and also upperFirstAndLast is an extension function ;)
import learnkotlin._09functions.upperFirstAndLast as transform

// again, private means visible from the same file only
private fun privateTopLevelFun() = "i'm private to this file"

// and internal means internal to the module
internal fun internalTopLevelFun() = "i am internal to this module"
// try to import those in different files and modules!

fun main(args: Array<String>) {
    println(topLevelFunction("Hello from another file"))
    println(topLevelFunctionFromAnotherModule("I'm in another module"))
    println(PrinterCopyrightNotice.getCopyRightNotice())
    println(ACCOUNTING.getDepartmentInfo())
    println("somestring".transform())
    println(privateTopLevelFun())
    println(internalTopLevelFun())
}