package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerExample {

    public static void nameAndActivities(){

        BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

        Consumer<String> stringConsumer = (name) -> System.out.println("name is  :" + name);

        List<Student> students = StudentDataBase.getAllStudents();

        students.forEach((s) -> studentBiConsumer.accept(s.getName(),s.getActivities()));

        BiConsumer<String, List<String>> studentGradeBiConsumer = (name, activities) -> {
            int totalAct = activities.size();
            System.out.println("Name : " + name + ": Activities : " + totalAct);

        };
        students.forEach((s) ->studentGradeBiConsumer.accept(s.getName(), s.getActivities()));
        System.out.println("---------------");
        students.forEach(student -> {
           int totalAct = student.getActivities().size();
            System.out.println("Name : " + student.getName() + ": Activities : " + totalAct);

        });
    }

    public static void main(String[] args) {


        BiConsumer<String, String> biConsumer = (a,b) -> {
            System.out.println(" a : "  +  a + " b : " + b );
        };
        biConsumer.accept("java7" , "java8");

        BiConsumer<Integer, Integer> multiply = (a,b) -> {
            System.out.println("Multiplication : " + (a * b));
        };

        BiConsumer<String, Integer> test = (a,b) ->{
            System.out.println("a : " + a + " b : " + b * 50);
        };


        BiConsumer<Integer, Integer> addition = (a,b) -> {
            System.out.println("Addition : " + (a + b));
        };

        BiConsumer<Integer, Integer> division = (a,b) -> {
            System.out.println("Division : "  + (a / b));
        };


        multiply.andThen(addition).andThen(division).accept(10,5);



        test.accept("abcd", 11);
        nameAndActivities();

    }
}
