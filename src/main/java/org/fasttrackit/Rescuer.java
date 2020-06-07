package org.fasttrackit;

public class Rescuer{

    String name;
    double budget;

    public void feeding(Animal animal, AnimalFood food){
        System.out.println(name + " just gave some " + food.name + " food to " + animal.name + ".");
        animal.hungerLevel--;
    }

    public  void playActivity(Animal animal, RecreationActivity recreationActivity){
        System.out.println(name + " is playing " + recreationActivity.name + " with " + animal.name );
        animal.moodLevel++;
    }
}
