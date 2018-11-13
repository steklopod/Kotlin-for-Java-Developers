package learnkotlin._07accessmodifiers

class ClassWithCustomGetterAndSetters(name: String = "JohnDoe") {
    // equivalent to Java's
    // this.name = name
    // custom getter / setter HAS to follow the declaration
    var name = name
    get() {
        println("using custom get")
        return field
    }
    set(value) {
        println("using custom setter")
        field = value
    }
}