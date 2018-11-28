package _25fileio

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource
import java.io.File
import java.io.InputStreamReader

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


fun String.streamFromResource(): InputStreamReader = ClassPathResource(this).file.reader()
fun String.linesFromFile(): List<String> = ClassPathResource(this).file.reader().use { it.readLines() }
fun String.readTextFromFile() = ClassPathResource(this).file.reader().use { it.readText() }
fun String.fromClathPathForEachLine(work: (String) -> Unit) {
    ClassPathResource(this).file.reader()
        .forEachLine { work(it) }
}

infix fun ObjectMapper.prettyJson(node: JsonNode) = this.writerWithDefaultPrettyPrinter().writeValueAsString(node)

fun Exception.stackTraceAsString() = this.stackTrace.map {
    with(StringBuilder()) {
        append(it.toString())
        append("\n")
    }
}.toString()