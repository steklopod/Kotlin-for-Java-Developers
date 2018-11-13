package learnkotlin._00javacode;

public class Dummyclass {

    public String isVacationTimePrimitive (boolean onVacation) {
        return onVacation ? "i'm on vacation" : "i'm working";
    }

    public String isVacationTimeBoolean (Boolean onVacation) {
        return onVacation ? "i'm on vacation" : "i'm working";
    }

    public void printNumbers(int[] numbers) {
        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
