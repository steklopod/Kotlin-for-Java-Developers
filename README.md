[Kotlin](https://kotlinlang.org/) создан Jetbrains и предназначен, чтобы охватить некоторые из 
наиболее болезненных аспектов в Java: подробный, более кратким и безопасности на исключениях. 
Кроме того, он предназначен, чтобы быть проще, чем Scala.

`Kotlin` - это статически типизированный объектно-ориентированный язык на JVM, как и Java. 
Это означает, что весь код, написанный на Java, может быть использован в Kotlin и наоборот.

Данный проект содержи примеры кода из курса [Kotlin for Java Developers](https://learnprogramming.academy/courses/kotlin-for-java-developers/).

Ниже приведены примеры для беглого ознакомления с данным языком:
#### Hello World!

Начнем с простого:

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

В Kotlin нам больше не нужно проверять `nullability`. Для этой цели Котлин вводит символ 
**`?`** для этого.

Kotlin:
```kotlin
var file = File("myFile")
println(file?.size())
```

Java:
```java
File file = new File("myFile");
if (file != null)  System.out.println(file.size());

```

## Smart Casts (умное приведение типов)

Еще одна особенность, которая мне очень нравится в Kotlin, - это умные приведение типов. 

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

Это реализация шаблона `Singleton` в Java:

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

Однако в Kotlin у нас есть новый тип класса **`object`**, который по своей природе является 
одноэлементным:

```kotlin
object MySingleton {
    val property = 10
}

// MySingleton.property
```

## Unit vs Void

`Unit` в Kotlin эквивалентна в Java `void`.

## Strings

В Kotlin переменные заменяются непосредственно в строках.

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

## Delegation Properties (Свойства Делегирования)
Kotlin имеет очень хорошую функцию для реализации [шаблона делегирования](https://ru.wikipedia.org/wiki/Шаблон_делегирования):

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

Автомобиль определяется двигателем, и мы делегируем его свойству **`e`** `(e: Engine): Engine by e`.

Тем не менее, я думаю, что наиболее интересной особенностью являются свойства делегирования. 
Мы можем настроить свойства, чтобы иметь делегат между ними:

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
В вышеприведенном примере, мы изменяем поведение двигателя в зависимости от поля скорости в экземпляр HybridCar.

Существует три типа встроенных делегатов в Котлине:

### Lazy (Ленивый):

Значение вычисляется только при первом доступе:

```kotlin
import kotlin.lazy

class LazyCar {
    val engine: String by lazy {
        println("computed!")
        "Gas"
    }
}
```

### Observable (Наблюдаемый):

Этот делегат позволяет отслеживать изменения в свойствах:

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

### Хранение свойств в отображении (в Map):

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

## Functions

Kotlin работает как Javascript, где вы можете написать функцию в любой области, и эта функция будет доступна напрямую. 
В Java, все функции привязаны к классу: 

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

## Overloading (перегрузка)

Kotlin позволяет задавать значения по умолчанию в параметрах функции. Это то, чего мне не 
хватало некоторое время в Java, поэтому нам не нужно перегружать слишком много методов, как нам 
приходилось делать до сих пор.

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

Оба фрагмента кода эквивалентны.

# Classes (классы)

В Java, классы имеют поля и сеттеры/геттеры для этих полей. В Kotlin классы имеют только 
изменяемые или неизменяемые (`inmmutable`) свойства. 

Kotlin:
```kotlin
class User(val name: String, var age: Int)

fun main(args: Array<String>) {
    var user = User("Jose", age = 32)
    user.age = 33 // This is ok, age property is a var and then mutable.
    // user.name = "Ana" This is wrong! name property is a val and then immutable.
}
```

Как мы видим, мы объявляем свойство как неизменяемое с помощью `val` и изменяемое с помощью `var`. 
Этот класс эквивалентен:

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

## ToString & Equals/HashCode

В Java нам слишком часто приходилось реализовывать `toString`, `equals` и `hashCode`. 
В Kotlin мы можем использовать [классы данных](https://kotlinlang.ru/docs/reference/data-classes.html.

Kotlin:
```kotlin
data class User(val name: String, var age: Int)
```

В Java это эквивалентно (мы пропустили хэш-код и некоторые другие методы):

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

Отметим, что мы можем использовать [Lombok]((https://projectlombok.org/)) в Java для 
автоматической реализации этих методов, как:

```java
@Data
public class User {
    // ...
}
```

## Inheritance (Наследование)
В Java по умолчанию все классы могут наследовать, но классы, помеченные как `final`. 
В Котлин, наоборот, мы не можем наследовать класс, если помечен как `open`:


```kotlin
open class Car(var engine: String)

public class Ferrari: Car("diesel")
```

## Extensions (Расширения)
[Расширения](https://kotlinlang.ru/docs/reference/extensions.html) в Kotlin работают как в C# 
и похожи на Javascript. Мы можем добавлять 
пользовательские расширения в наши классы или даже в свойства и группировать эти расширения в пакет.

```kotlin
package examples.kotlin

open class Office

fun Office.hasTable() = true

fun main(args: Array<String>) {
    val myOffice = Office()
    println("Office has table ${myOffice.hasTable()}") // output: Office has table yes
}
```

Если мы переместим `hasTable` в другой пакет, все, что нам нужно сделать, это импортировать 
другой пакет, и у нас будет видимость для вызова нового метода или расширения.


_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._