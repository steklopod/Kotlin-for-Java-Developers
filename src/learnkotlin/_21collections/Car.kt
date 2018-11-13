package learnkotlin._21collections

class Car(val color: String, val model: String, val year: Int) {
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}