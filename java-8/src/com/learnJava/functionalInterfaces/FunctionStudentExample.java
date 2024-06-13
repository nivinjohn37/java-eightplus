package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> function = (students -> {

        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach((student -> {

            if (PredicateStudentExample.p1.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        }));

        return studentGradeMap;

    });
    static BiPredicate<List<String>, Double> pred1 = (act, gpa) -> act.size() > 2 && gpa > 2.0;

    static BiConsumer<Map<String, Integer>, Student> consumer1 = (map, student) -> map.put(student.getName() + " - " + student.getGender() , student.getActivities().size());

    static Function<List<Student>, Map<String, Integer>> function2 = (students -> {
        Map<String, Integer> studentGenderActMap = new HashMap<>();
        students.forEach(student -> {
            if (pred1.test(student.getActivities(), student.getGpa())) {
                consumer1.accept(studentGenderActMap, student);
            }
        });
        return studentGenderActMap;
    });

    public static void main(String[] args) {

        System.out.println(function.apply(StudentDataBase.getAllStudents()));
        System.out.println("************************************");
        System.out.println(function2.apply(StudentDataBase.getAllStudents()));

    }
}
