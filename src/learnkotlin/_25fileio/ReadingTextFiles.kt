package learnkotlin._25fileio

import java.io.File

fun main(args: Array<String>) {
    val lines = File("textfile.txt").reader().readLines()
    lines.forEach { println(it) }

    // use will close the reader for us (readText does not / readLines does!)
    val lines2 = File("textfile.txt").reader().use { it.readText() }

    // closes the resource for us, hard limit of 2GB
    val lines3 = File("textfile.txt").readText()

    // all of the above read the whole file. To read a file line by line
    val lines4 = File("textfile.txt").reader().forEachLine { println(it) }

    // or as a sequence
    val lines5 = File("textfile.txt")
        .reader()
        .useLines {
            it.forEach { println(it) }
        }
}