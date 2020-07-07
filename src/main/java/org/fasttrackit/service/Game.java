package org.fasttrackit.service;

import org.fasttrackit.controler.StdInControler;
import org.fasttrackit.controler.utils.ScannerUtils;
import org.fasttrackit.domain.*;
import org.fasttrackit.domain.animals.Animal;
import org.fasttrackit.domain.animals.Cat;
import org.fasttrackit.domain.animals.Dog;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
//    Animal animal = new Animal("Max", "German BRAC", 5);
//    Rescuer rescuer = new Rescuer();
//    Veterinarian veterinarian = new Veterinarian();

    StdInControler controler = new StdInControler();

    private List<AnimalFood> availableFoods = new ArrayList<>();
    private RecreationActivity[] availableActivitys = new RecreationActivity[3];


    public void start() {
        System.out.println("Welcome to the Animal Rescuer game!");
        System.out.println();

        displayFood();
        displayActivity();

    }


    private void initDog() {
        Animal dog = new Dog();
        System.out.println("Enter the name please: ");
        dog.setName(controler.getNameOfDog());
        dog.setBreed("German BRAC");
        dog.setAge(5);
        dog.setGender("Male");
        dog.setFavoriteFood("Dry food");
        dog.setFavoriteRecreationActivity("Running after the ball.");
        dog.setHealthLevel(5);
        dog.setHungerLevel(3);
        dog.setMoodLevel(4);
    }

    private void initCat() {
        Animal cat = new Cat();
        System.out.println("Enter the name please: ");
        cat.setName(controler.getNameOfCat());
        cat.setBreed("British Shorthair");
        cat.setAge(3);
        cat.setGender("Female");
        cat.setFavoriteFood("Whiskas");
        cat.setFavoriteRecreationActivity("Capnit toys");
        cat.setHealthLevel(3);
        cat.setHungerLevel(3);
        cat.setMoodLevel(4);

    }


    private void initFood() {
        AnimalFood food = new AnimalFood();
        food.setName("Dry food");
        food.setPrice(50);
        food.setQuantity(5);
        food.setExpirationDate(LocalDate.of(2020, 9, 15));

        AnimalFood secondFood = new AnimalFood();
        secondFood.setName("Meet");
        secondFood.setPrice(42);
        secondFood.setQuantity(3);
        secondFood.setExpirationDate(LocalDate.of(2020, 9, 17));

        AnimalFood thirdFood = new AnimalFood();
        thirdFood.setName("Chicken");
        thirdFood.setPrice(38);
        thirdFood.setQuantity(6);
        thirdFood.setExpirationDate(LocalDate.of(2020, 7, 26));

        availableFoods.add(food);
        availableFoods.add(secondFood);
        availableFoods.add(thirdFood);

        displayFood();
    }


    private void displayFood() {
        System.out.println("Available food: ");

        int count = 0;

        for (AnimalFood food : availableFoods) {
            count++;
            System.out.println(count + ". " + food.getName());
        }
    }


    private void initActivity() {
        RecreationActivity recreationActivity = new RecreationActivity();
        recreationActivity.setName("Running after the ball");

        RecreationActivity secondRecreationActivity = new RecreationActivity();
        secondRecreationActivity.setName("It spins after the tail");

        RecreationActivity thirdRecreationActivity = new RecreationActivity();
        thirdRecreationActivity.setName("It smells like traces");

        availableActivitys[0] = recreationActivity;
        availableActivitys[1] = secondRecreationActivity;
        availableActivitys[2] = thirdRecreationActivity;

        displayActivity();

    }

    private void displayActivity() {
        System.out.println("Available activity: ");

        for (int i = 0; i < availableActivitys.length; i++) {
            if (availableActivitys[i] != null) {
                System.out.println(i + 1 + ". " + availableActivitys[i].getName());
            }
        }
    }
}
