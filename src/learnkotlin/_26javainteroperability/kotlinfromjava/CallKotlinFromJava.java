package learnkotlin._26javainteroperability.kotlinfromjava;

import java.io.IOException;

public class CallKotlinFromJava {

    public static void main(String[] args) {

        // this is familiar
        Car car = new Car("Datsun", "orange", 1977, true);

        // calling the top level function is not. For the top level function, a static class is created under the covers
        // with the file name plus extension. By default this would be CarKt, but we can change it with the JvmName
        // annotation (see Car.kt)
        KotlinCar.topLevel();

        // same goes for extension functions, but we have to pass an instance as arg. not very nice
        KotlinCar.print(car);

        // getters are generated under the covers for vals, setters for vars as well
        System.out.println(car.getColor());

        // for booleans, the getter is called is* rather than get*
        car.isAutomatic();
        // sets are the same
        car.setAutomatic(false);

        // with the annotation @JvmField we can access properties directly bypassing the generated constructor
        System.out.println(car.year);

        // to access the companion object we can use the Companion keyword
        Car.Companion.carComp();
        // or use the JvmStatic annotation, the compiler will compile two versions - an instance method and a static one
        Car.staticCarComp ();
        // for variables we have to annotate with @JvmField
        System.out.println(Car.isAuto);

        // to use objects we must use the single INSTANCE. Or annotate with @JvmStatic
        SingletonCar.INSTANCE.doCarWhatACarDoes();

        // constants do not need annotations
        System.out.println(Car.constant);

        // nothing stops us from passing null to a non-null type. An exception will be thrown:
        // car.printMe(null);

        // without the @Throws annotation, we cannot catch the exception
        try {
            car.throwIOException();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        // we can omit values in the function call if we annotate the kotlin function with @JvmOverloads, which will
        // cause the compiler to generate every possible method signature, not just the one with all params required
        car.defaultArgs("dsa");
    }
}
