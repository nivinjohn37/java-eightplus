package com.learnJava.collections;

import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;

class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}

public class ConsumerExample {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());

        // Consumer that works with Animals
        Consumer<Animal> animalConsumer = animal -> animal.makeSound();

        // This is valid because Dog and Cat are subtypes of Animal
        performAction(dogs, animalConsumer);
        performAction(cats, animalConsumer);
    }

    public static <T> void performAction(List<T> list, Consumer<? super T> action) {
        for (T t : list) {
            action.accept(t);
        }
    }
}
