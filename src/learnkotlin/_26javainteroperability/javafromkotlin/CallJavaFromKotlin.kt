package learnkotlin._26javainteroperability.javafromkotlin

fun main(args: Array<String>) {
    // creating an instance of a java-class Car
    var car = Car("Green", "Ford", 1966)

    // we set properties just like we do in Kotlin; works only if the Java class has getters and setters or if the
    // field is public
    car.model = "DeTomaso"
    println(car)

    // the default return type from a java getter that isn't annotated is the nullable type
    // assigning null here works without any special precautions
    var model = car.model
    model = null
    // javaClass can only be called on non-nullable types, so this is not available to us
    // model.javaClass

    // the @Nullable annotation informs the compiler that a null value may occur
    val color: String = car.color!!

    // or that null as value is fine. In this case, it is not required
    car.color = null

    // this will throw a IllegalArgumentException, as the @NotNull annotation is checked at runtime
    // car.year = null

    // or if we get the non-nullable property,
    val year = car.color

    // calling a java method with variable argument number
    car.variableMethod(5, "Hello", "World ")
    // if we are passing an array, we need the spread operator
    val array = arrayOf("Hello", "from", "this", "array")
    car.variableMethod(4, *array)

    // calling a method that wants a primitive array, we need to create explicitly, or convert
    car.wantsPrimitiveArray(arrayOf(1, 2, 3).toIntArray())
    car.wantsPrimitiveArray(intArrayOf(1, 2, 3))

    // java Objects correspond to Any in Kotlin, but Kotlin any only has toString, hasCode and equals methods
    // to use methods in the Object class we must cast it explicitly
    (car.anObject as java.lang.Object)

    // static methods and fields are converted to companion objects in kotlin
    println("${Car.x}")
    println("${Car.xString()}")

    // see comments on this method in Car.java. If a method accepts a SAM interface, we can instead just pass a lambda
    car.demoSAM({ println("i am a lambda from Kotlin!") })
}