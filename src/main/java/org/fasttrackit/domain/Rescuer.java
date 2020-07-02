package org.fasttrackit.domain;

public class Rescuer{

   private String name;
   private double budget;



    public void feeding(Animal animal, AnimalFood food) {

        if (food.getName().equals(animal.getFavoriteFood())) {
            System.out.println("Yeah, it's your favorite food.");
            animal.setMoodLevel(animal.getHungerLevel() + 2);
            System.out.println("Mood level is: " + animal.getHungerLevel());
        } else {
            System.out.println("Yes, i know, is not your favorite food.");
            animal.setMoodLevel(animal.getHungerLevel() - 1);
            System.out.println("Mood level is: " + animal.getHungerLevel());
        }

        System.out.println(name + " just gave some " + food.getName() + " to " + animal.getName() + ".");

    }

    public  void playActivity(Animal animal, RecreationActivity recreationActivity) {

        if (recreationActivity.getName().equals(animal.getFavoriteRecreationActivity())) {
            System.out.println("It's your favorite activity!");
            animal.setMoodLevel(animal.getMoodLevel() + 2);
            System.out.println("Mood level is: " + animal.getMoodLevel());
        } else {
            System.out.println("Yep, it's not your favorite activity, but it's fun.");
            animal.setMoodLevel(animal.getMoodLevel() + 1);
            System.out.println("Mood level is: " + animal.getMoodLevel());

        }

        System.out.println(name + " is playing " + recreationActivity.getName() + " with " + animal.getName() );

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
