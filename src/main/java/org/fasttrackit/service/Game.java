package org.fasttrackit.service;

import org.fasttrackit.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Animal animal = new Animal("Max", "German BRAC", 5);
    Rescuer rescuer = new Rescuer();
    Veterinarian veterinarian = new Veterinarian();

    private List<AnimalFood> availableFoods = new ArrayList<>();
    private RecreationActivity[] availableActivitys = new RecreationActivity[3];


    public void start() {
        System.out.println("Welcome to the Animal Rescuer game!");

        initFood();
        System.out.println("");
        initActivity();
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
        secondFood.setPrice(38);
        secondFood.setQuantity(6);
        secondFood.setExpirationDate(LocalDate.of(2020, 7, 26));

        availableFoods.add(food);
        availableFoods.add(secondFood);
        availableFoods.add(thirdFood);

        displayFood();
    }


    private void displayFood() {
        System.out.println("Available food: ");

        for (int i = 0; i < availableFoods.size(); i++){
            System.out.println(i + 1 + ". " + availableFoods.get(i).getName());
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
