package learnkotlin._027challenge6.part2.callkotlinfromjava;

import learnkotlin._027challenge6.part2.kotlincode.Challenge;
import learnkotlin._027challenge6.part2.kotlincode.Employee;
import learnkotlin._027challenge6.part2.kotlincode.KotlinCodeKt;

public class CallKotlinFromJava {

    public static void main(String[] args) {

        KotlinCodeKt.sayHelloToJava("Student");

        Employee employee = new Employee("John", "Smith", 2010);
        employee.startYear = 2009;

        Challenge.doMath(5, 4);

        employee.takesDefault("arg1");
    }
}