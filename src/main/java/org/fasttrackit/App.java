package org.fasttrackit;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args ) {

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

    AnimalFood food = new AnimalFood();
        food.price = 50;
        food.favoriteFood = "Dry food";
        food.quantity = 15.5;
        food.expirationDate = LocalDate.of(2020, 8, 8);
//    AnimalFood food2 = new AnimalFood();
//        food2.price = 70;
//        food2.name = "Meet";
//        food2.quantity = 20.0;
//        food2.expirationDate = LocalDate.of(2020, 9, 6);

    RecreationActivity recreationActivity = new RecreationActivity();
        recreationActivity.favoriteActivity = "Running after the ball";
        recreationActivity.name = "Running";

    Veterinarian veterinarian = new Veterinarian();
        veterinarian.name = "Bill";
        veterinarian.specialization = "Veterinary medicine";




    rescuer.feeding(animal, food);
    rescuer.playActivity(animal,recreationActivity);
    }
}




