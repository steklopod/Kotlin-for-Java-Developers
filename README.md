[Kotlin](https://kotlinlang.org/) создан Jetbrains и предназначен, чтобы охватить некоторые из 
наиболее болезненных аспектов в Java: подробный, более кратким и безопасности на исключениях. 
Кроме того, он предназначен, чтобы быть проще, чем Scala.

`Kotlin` - это статически типизированный объектно-ориентированный язык на JVM, как и Java. 
Это означает, что весь код, написанный на Java, может быть использован в Kotlin и наоборот.


# Основы

## Hello World!

Let's start from the basics

Kotlin:
```kotlin
package examples.kotlin

fun main(args: Array<String>) {
    println("Hello World!")
}
```
Java:
```java


public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

## Null Safety

In Kotlin, we don't need to check nullability any longer (unless we're using some Java library). For this purpose, Kotlin introduces the *?* character for this.

Kotlin:
```kotlin
var file = File("myFile")
println(file?.size())
```

Java:
```java
File file = new File("myFile");
if (file != null) {
    System.out.println(file.size());
}
```

## Smart Casts

Another feature I really like in Kotlin is the smart casts. 

Kotlin:
```kotlin
class Service {
    public fun callService() {
        // ..
    }
}

public fun myFunction(obj: Any) {
    if (obj is Service) {
        obj.callService() 
    }
}
```

Java:
```java
class Service {
    public void callService() {
        // ..
    }
}

public void myFunction(Object obj) {
    if (obj instanceof Service) {
        ((Service) obj).callService();
    }
}
```

## Singletons

This is the implementation of the Singleton pattern in Java:

```java
public class MySingleton {
    private static MySingleton INSTANCE = null;

    private MySingleton(){}

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MySingleton();
        }
    }

    public static MySingleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
}
```

However, in Kotlin, we have a new type of class called *object* which is a singleton by nature:

```kotlin
object MySingleton {
    val property = 10
}

// MySingleton.property
```

## Unit vs Void

Unit in Kotlin is the equivalent in Java to Void.

## Strings

As in Groovy, in Kotlin the variables are replaced directly in strings.

Kotlin:
```kotlin
var name = "Jose"
var helloName = "Hello $name!"
```

Java:
```java
String name = "Jose";
String helloName = String.format("Hello %s!", name);
```

## Delegation Properties

Kotlin has a very nice feature to implement the [delegation pattern](https://en.wikipedia.org/wiki/Delegation_pattern):

```kotlin
interface Engine {
    fun printEngine()
}

class Diesel(val power: Int) : Engine {
    override fun printEngine() { println("Diesel $power") }
}

class Car(e: Engine) : Engine by e

fun main(args: Array<String>) {
    val engine = Diesel(10)
    Car(engine).printEngine()
}
```

Car is defined by an engine and we delegate it to the *e* property "(e: Engine) : Engine by e".

However, I think the most interesting feature is the [**delegation properties**](https://kotlinlang.org/docs/reference/delegated-properties.html). We can configure the properties to have a delegate in between:

```kotlin
import kotlin.reflect.KProperty

class EngineDelegate {
    private val speedLimit : Int = 5

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return if (thisRef is HybridCar && thisRef.speed < speedLimit) "Electric" else "Gas"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been manually set to '${property.name}' in $thisRef.")
    }
}

class HybridCar(var speed : Int) {
    var engine: String by EngineDelegate()
}

fun main(args: Array<String>) {
    val car = HybridCar(10)
    println(car.engine) // output: Gas
    car.speed = 2
    println(car.engine) // output: Electric
}
```

In the above example, we are changing the behaviour of the engine depending on the speed field into the HybridCar instance. 

There are three types of in-built delegates in Kotlin:

**- Lazy:**

The value gets computed only upon first access:

```kotlin
import kotlin.lazy

class LazyCar {
    val engine: String by lazy {
        println("computed!")
        "Gas"
    }
}
```

**- Observable:**

This delegate allows to track the changes in the properties:

```kotlin
import kotlin.properties.Delegates

class SmartCar {
    var speed : Int by Delegates.observable(10, {
        prop, old, new -> println("Changed from $old to $new")
    })
}

fun main(args: Array<String>) {
    val smartCar = SmartCar()
    smartCar.speed = 10 // Output: Changed from 10 to 10
    smartCar.speed++ // Output: Changed from 10 to 11
}
```

**- Storing Properties in a Map:**

```kotlin
class SerializedCar (val map: Map<String, Any?>) {
    val speed : Int by map
    val engine : String by map
}

fun main(args: Array<String>) {
    val map = HashMap<String, Any?>()
    map.put("speed", 10)
    map.put("engine", "Gas")
    var serializedCar = SerializedCar(map)
    println("Car with engine ${serializedCar.engine} and speed ${serializedCar.speed}") // Output: Car with engine Gas and speed 10
}
```

# Functions

Kotlin works like Javascript where you can write a function under any scope and this function will be directly available. In Java, all the functions are tied to a class. 

Kotlin:
```kotlin
fun sayHello(name: String) {
    println("Hello $name!")
}

fun main(args: Array<String>) {
    sayHello("Jose")
}
```

Java:
```java
public class Functions {
    public static void sayHello(String name) {
        System.out.println(String.format("Hello %s!", name));
    }

    public static void main(String[] args) {
        Functions.sayHello("Jose");
    }
}
```

## Overloading

Kotlin allows to set default values in the parameters of a function. This is something I was realling missing from a while in Java, so we don't need to overload too many methods as we had to do so far.

Kotlin:
```kotlin
fun doSomething(name: String, number: Int = 0, address: String = "") {
    // ..
}
```

Java:
```java
public void doSometrhing(String name) {
    doSomething(name, 0);
}

public void doSomething(String name, int number) {
    doSomething(name, number, "");
}

public void doSomething(String name, int number, String address) {
    // ..
}
```

Both code snippets are equivalent.

# Classes

In Java, classes have fields and setters/getters for these fields. In Kotklin, classes only have mutable or inmmutable properties. 

Kotlin:
```kotlin
class User(val name: String, var age: Int)

fun main(args: Array<String>) {
    var user = User("Jose", age = 32)
    user.age = 33 // This is ok, age property is a var and then mutable.
    // user.name = "Ana" This is wrong! name property is a val and then immutable.
}
```

As we can see, we declare a property as immutable using *val* and mutable using *var*. This class is equivalent to:

Java:
```java
public class User {

    private final String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        User user = new User("Jose", 32);
        user.setAge(33);
        // user.setName() does not exist
    }
}
```

## ToString and Equals/HashCode

In Java, we needed to implement the toString, equals and hashCode too often. In Kotlin, we can only use the [*data*](https://kotlinlang.org/docs/reference/data-classes.html) modified.

Kotlin:
```kotlin
data class User(val name: String, var age: Int)
```

In Java, this is equivalent to (we skipped the hashCode and some other methods):

```java
public class User {

    // ...

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(age, user.age);
    }

    @Override
    public String toString() {
        return String.format("User(name='%s', age=%s)", name, age);
    }
}
```

Let's note that we can use [Lombok](https://projectlombok.org/) in Java to auto-implement these methods as:

```java
@Data
public class User {
    // ...
}
```

## Inheritance

In Java, by default all the classes are able to be inherit, but the classes marked as final. In Kotlin, it's the oppositve, we cannot inherit to a class unless is marked as *open*:

```kotlin
open class Car(var engine: String)

public class Ferrari: Car("diesel")
```

## Extensions

[Extensions](https://kotlinlang.org/docs/reference/extensions.html) in Kotlin works like in C# and similar to Javascript. We can add custom extensions to our classes or even to properties and group these extensions into a package.

```kotlin
package examples.kotlin

open class Office

fun Office.hasTable() = true

fun main(args: Array<String>) {
    val myOffice = Office()
    println("Office has table ${myOffice.hasTable()}") // output: Office has table yes
}
```

If we move the hasTable into another package, all we need to do is to import the other package and we will have visility to invoke the new method or extension.

# Conclusion

There are a lot of topics around Kotlin and this post will remain in work-in-progress state for a while. I will be adding new sections in the future while I learn Kotlin. 

See [my Github repository](https://github.com/Sgitario/kotlin-for-java-developers) for a full example.