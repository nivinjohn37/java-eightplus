package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerExample {

    static Consumer<Student>  c1= p -> System.out.println(p);

    static Consumer<Student>  c2= p -> System.out.print(p.getName().toUpperCase());

    static Function<String, String> c45= s -> s.toUpperCase();


    static Consumer<Student>  c3= p -> System.out.println(p.getActivities());

    static Consumer<Student> c4 = p -> System.out.println(p.getGpa());



    public static void printName(){

        List<Student> personList = StudentDataBase.getAllStudents();

        personList.forEach(c1);

    }

    public static void printNameAndActivities(){
        System.out.println("printNameAndActivities : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(c4.andThen(c3));
    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach((s) -> {
            if( s.getGradeLevel()>=3 && s.getGpa()>3.9){
                c2.andThen(c3).accept(s);
            }
        });
    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        System.out.println(c45.apply("test"));

        c1.accept("java8");

        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();





    }
}
