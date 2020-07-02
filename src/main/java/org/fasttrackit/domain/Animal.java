package org.fasttrackit.domain;

public class Animal {

   private String name;
   private String breed;
   private String favoriteFood;
   private String favoriteRecreationActivity;
   private String gender;
   private int age;
   private int healthLevel;
   private int hungerLevel;
   public int moodLevel;


    public Animal(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }


    public Animal dysplayAnimalMood() {
        if (getMoodLevel() > 5) {
            System.out.println("Mood level is " + getMoodLevel());
        }
        return this;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteRecreationActivity() {
        return favoriteRecreationActivity;
    }

    public void setFavoriteRecreationActivity(String favoriteRecreationActivity) {
        this.favoriteRecreationActivity = favoriteRecreationActivity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }


}
