package learnkotlin._11Objects

import java.time.Year

fun main(args: Array<String>) {
    println(PrinterCopyrightNotice.getCopyRightNotice())
}

object PrinterCopyrightNotice {

    val currentYear = Year.now().value

    fun getTagLine() = "Best Printer Company"
    fun getCopyRightNotice() = "\u00A9 - ${getTagLine()}: $currentYear"
}