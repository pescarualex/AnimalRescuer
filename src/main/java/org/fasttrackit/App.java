package org.fasttrackit;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args ) {

    Rescuer rescuer = new Rescuer();
    rescuer.name = "Alex";
    rescuer.budget = 1000;

    Animal dog = new Animal();
    dog.name = "Max";
    dog.age = 5;
    dog.breed = "German BRAC";
    dog.favoriteFood = "Dry food";   // like a pedigree
    dog.favoriteRecreationActivity = "Running after the ball";
    dog.healthLevel = 2;
    dog.hungerLevel = 2;
    dog.moodLevel = 2;

    AnimalFood food = new AnimalFood();
    food.price = 50;
    food.name = "Dry food";
    food.quantity = 15.5;
    food.expirationDate = LocalDate.of(2020, 8, 8);

    RecreationActivity recreationActivity = new RecreationActivity();
    recreationActivity.name = "Running after the ball";

    Veterinarian veterinarian = new Veterinarian();
    veterinarian.name = "Bill";
    veterinarian.specialization = "Veterinary medicine";

    }
}




