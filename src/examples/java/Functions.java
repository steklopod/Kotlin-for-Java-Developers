

public class Functions {

    public void doSometrhing(String name) {
        doSomething(name, 0);
    }

    public void doSomething(String name, int number) {
        doSomething(name, number, "");
    }

    public void doSomething(String name, int number, String address) {
        // ..
    }

    public static void sayHello(String name) {
        System.out.println(String.format("Hello %s!", name));
    }

    public static void main(String[] args) {
        Functions.sayHello("Jose");
    }
}
