package org.fasttrackit;

public class App 
{
    public static void main( String[] args )
    {
    Rescuer rescuer = new Rescuer();
    rescuer.nameOfRescuer = "Alex";
    rescuer.budget = 1000;

    Animal dog = new Animal();
    dog.name = "Max";
    dog.age = 5;
    dog.breed = "German BRAC";
    dog.favoriteFood = "dry food";   // like a pedigree
    dog.favoriteRecreationActivity = "running after the ball";
    dog.healthLevel = 2;
    dog.hungerLevel = 2;
    dog.moodLevel = 2;

    AnimalFood food = new AnimalFood();
    food.price = 50;
    food.nameOfFood = "Dry food";
    food.disponibleFoodQuantity = 15.5;
//    food.expirationDate = 24,11,2020;

    RecreationActivity recreationActivity = new RecreationActivity();
    recreationActivity.nameOfRecreationActivity = "running after the ball";

    Veterinarian veterinarian = new Veterinarian();
    veterinarian.nameOfVeterinarian = "Bill";
    veterinarian.specialization = "veterinary medicine";

    }
}




