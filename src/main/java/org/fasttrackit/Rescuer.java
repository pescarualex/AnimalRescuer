package org.fasttrackit;

public class Rescuer{

    String name;
    double budget;

    public void feeding(Animal animal, AnimalFood food){

        if (food.name.equals(food.favoriteFood)){
            System.out.println("Yeah, it's your favorite food.");
            animal.moodLevel++;
            System.out.println("Mood level is: " + animal.moodLevel);
        } else {
            System.out.println("Yes, i know, is not your favorite food.");
        }

        System.out.println(name + " just gave some " + food.name + " food to " + animal.name + ".");
        animal.hungerLevel--;
    }

    public  void playActivity(Animal animal, RecreationActivity recreationActivity){

        if (recreationActivity.name.equals(recreationActivity.favoriteActivity)){
            System.out.println("It's your favorite activity!");
            animal.moodLevel+= 2;
            System.out.println("Mood level is: " + animal.moodLevel);
        } else {
            System.out.println("Yep, it's not your favorite activity, but it's fun.");
            animal.moodLevel++;
            System.out.println("Mood level is: " + animal.moodLevel);
        }

        System.out.println(name + " is playing " + recreationActivity.name + " with " + animal.name );
        animal.moodLevel++;
    }
}
