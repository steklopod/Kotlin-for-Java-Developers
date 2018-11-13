package learnkotlin._26javainteroperability.javafromkotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Car {

    public static int x = 5;

    private String color;
    private String model;
    private int year;

    private Object anObject = "";

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public static String xString() {
        return "this is x: " + x++;
    }

    // SAM -> Single abstract method. Runnable has only one method: run; It is a SAM interface
    public void demoSAM(Runnable r) {

        new Thread(r).start();

//        new Thread( () -> System.out.println("I am in a thread, but use a lambda instead of an anonymous class")).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("i'm in a thread");
//            }
//        }).start();
    }

    public @Nullable String getColor() { return color; }

    public void setColor(@Nullable String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public @NotNull int getYear() {
        return year;
    }

    public void setYear(@NotNull int year) {
        this.year = year;
    }

    public Object getAnObject() {
        return anObject;
    }

    public void setAnObject(Object anObject) {
        this.anObject = anObject;
    }

    public void variableMethod(int num, String... strings) {
        for (String string: strings) {
            System.out.println(string);
        }
    }

    public void wantsPrimitiveArray(int[] someArray) {
        for (int integer: someArray) {
            System.out.println(integer);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
