package learnkotlin._05nullreferences

fun main(args: Array<String>) {

    // nullable with ?
    val strOne: String? = null

    val strTwo: String? = "Nullable, but not null"
    // now the compiler complains if we do
    // strTwo.toUpperCase()
    // smart casting to the rescue
    if (strTwo != null) {
        strTwo.toUpperCase()
    }

    // but even better, we can use the safe access expression
    strTwo?.toUpperCase()
    println("Let's see what happens here: ${strOne?.toUpperCase()}")

    // null checks
    val country = Country(3)
    val address = Address(country)
    val branch = Branch(address)

    val code1 = country.code
    // really easy nested null checks
    val code: Int? = branch?.address?.country?.code
    println(code)

    // or even chain null checks and provide default value
    val branch2: Branch = Branch(null)
    val code2: Int? = branch2?.address?.country?.code ?: 599
    println(code2)

    // elvis operator
    val nullString: String? = null
    val nonNullString: String = nullString ?: "Jail House Rock"

    // safe cast operator, datatype has to be nullable (: String?)
    val something: Any = arrayOf(1, 2, 3, 4)
    val someString = something as? String
    println(someString)

    // non null assertion with !! If str is indeed null, 'kotlin.Kotlin.NullPointerException' is thrown
    val noNullString: String? = "This is definitely noy null"
    val anotherNotNullString = noNullString!!.toUpperCase()

    // deliberately causing an exception. The exception references line 49, and not line 50 though!
    // val anotherNullString = nullString!!
    // val upperNullString = anotherNullString.toUpperCase()

    // avoid chaining non-null assertions in this fashion. If an exception occurs we dont know which of the values was null
    val someCode = branch!!.address!!.country!!.code

    val nonNullString2: String? = "Definitely not null"
    // method printText expects String, not String? so this would not work
    // printText(nonNullString2)
    // this works but is not good practise as it would throw an exception if the string was null.
    printText(nonNullString2!!)

    // long hand version of what we should do
    if (nonNullString2 != null) {
        printText(nonNullString2)
    }

    // and shorthand for the same thing
    // 'let' expects a lambda expression, and 'it' refers to the object that is calling 'let
    nonNullString2?.let { printText(it) }

    // '==' defers to the equal-method of nullString, but is null safe:
    println(nullString == nonNullString)

    // nullable arrays
    val nullIntArray = arrayOfNulls<Int?>(5)
    for (i in nullIntArray) {
        println(i)
    }
    println(nullIntArray[3].toString())
}

class Branch(val address: Address?)

class Address(val country: Country)

class Country(val code: Int)

fun printText(text: String) {
    println(text)
}