package org.fasttrackit;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

    Rescuer rescuer = new Rescuer();
        rescuer.setName("Alex");
        rescuer.setBudget(1000);

    Animal animal = new Animal("Max", "German BRAC", 5);
        animal.setName("Max");
        animal.setAge(5);
        animal.setBreed("German BRAC");
        animal.setFavoriteFood("Dry");   // like a pedigree
        animal.setFavoriteRecreationActivity("Running after the ball");
        animal.setHealthLevel(5);
        animal.setHungerLevel(5);
        animal.setMoodLevel(5);
        animal.setGender("Masculin");

    Animal dog = new Dog("Max", "German BRAC", 5);
        dog.dysplayAnimalMood();


    Animal cat = new Cat("Tesa","British Shorthair", 5 );
        cat.dysplayAnimalMood();

    AnimalFood food = new AnimalFood();
        food.setPrice(50);
        food.setName("meet");
        food.setQuantity(15.5);
        food.setExpirationDate(LocalDate.of(2020, 8, 8));

    RecreationActivity recreationActivity = new RecreationActivity();
        recreationActivity.setName("Running");

    Veterinarian veterinarian = new Veterinarian();
        veterinarian.setName("Bill");
        veterinarian.setSpecialization("Veterinary medicine");




    //rescuer.feeding(animal, food);
    //rescuer.playActivity(animal,recreationActivity);

    }
}