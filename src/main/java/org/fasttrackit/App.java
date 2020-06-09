package org.fasttrackit;

import java.time.LocalDate;
import java.util.Scanner;

public class App {



    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

    Rescuer rescuer = new Rescuer();
        rescuer.name = "Alex";
        rescuer.budget = 1000;

    Animal animal = new Animal();
        animal.name = "Max";
        animal.age = 5;
        animal.breed = "German BRAC";
        animal.favoriteFood = "Dry";   // like a pedigree
        animal.favoriteRecreationActivity = "Running after the ball";
        animal.healthLevel = 5;
        animal.hungerLevel = 5;
        animal.moodLevel = 5;

    Dog dog = new Dog();

    Cat cat = new Cat();


    AnimalFood food = new AnimalFood();
        food.price = 50;
        food.name = "meet";
        food.quantity = 15.5;
        food.expirationDate = LocalDate.of(2020, 8, 8);

    RecreationActivity recreationActivity = new RecreationActivity();
        recreationActivity.name = "Running";

    Veterinarian veterinarian = new Veterinarian();
        veterinarian.name = "Bill";
        veterinarian.specialization = "Veterinary medicine";




    //rescuer.feeding(animal, food);
    rescuer.playActivity(animal,recreationActivity);

    }
}




