package learnkotlin._23generics.declarationsitevariance.covariance

fun main(args: Array<String>) {

    // this works
    val shortList: List<Short> = listOf(1, 2, 3, 4, 4)
    convertNumberToInt(shortList)

    // this does not!
    val mutableShortList: MutableList<Short> = mutableListOf(1, 2, 3, 4, 4)
    // convertMutableNumberToInt(mutableShortList)

    // this is because there is a difference between class / sub-class and type / sub-type
    // For example
    // List is a class, it isn't a type
    // List<String> IS a type, so is List<Number>, List<Short> etc..
    // A List<Short> is a sub-type of List<Number> (not a sub class!, nothing is extended)
    // So really, when talking about generics we are more interested in the type / sub-type, and not so much
    // the class / sub-class
    // Same goes for super-class / super-type:
    // List<Number> is the super-type of List<Short>, and Number is the super-class of Short

    // So we know that Short is a sub-class of Number, but is it also a sub-type?
    // This leads to covariance, in an immutable list, covariance is preserved, so we are able to use generics.
    // In a mutable list, covariance is NOT preserved, so we cannot use generics

    // look at Covariance2 for and aside and more details on what covariance is, and how to declare something to preserve
    // this property, and look at the implementation of MutableList to see that it does not preserve covariance, whereas
    // the List class does preserve covariance. Basically, MutableList wants the exact type, and List wants any sub-type.
    // This again makes sense as there is nothing in the (immutable) List class that could change the list.
    // there is the @UnsafeVariance annotation that can be used with the type in the in position,
    // if you are absolutely certain that the method does not change the class (for exampe to check if a collection
    // contains a certain item)
}

fun convertNumberToInt(collection: List<Number>) {
    for (number in collection) {
        println("`${number.toInt()}")
    }
    // On the other hand, List preserves covariance, but we cannot edit it
    // collection.add(33)
}

fun convertMutableNumberToInt(collection: MutableList<Number>) {
    for (number in collection) {
        println("`${number.toInt()}")
    }
    // to illustrate the problem you could run into, if you were able to change the collection (of Short for example
    // like this:
    collection.add(23)
    // suddenly you'd have an Int in a list of Short...
}