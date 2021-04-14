package org.fasttrackit.domain.animals;

public class Dog extends Animal{

   private String waist;
   private int levelOfAggression;
   private static final int LEVEL_OF_CURIOSITY = 8;

    public Dog(String name, String breed, int age) {
        super(name, breed, age);
    }

    public Dog() {
    }

    @Override
    public Dog dysplayAnimalMood() {
        System.out.println("The mood level is increse. The dog wags it's tail. It is so happy!!");
        return this;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public int getLevelOfAggression() {
        return levelOfAggression;
    }


    public static int getLevelOfCuriozity() {
        return LEVEL_OF_CURIOSITY;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "waist='" + waist + '\'' +
                ", levelOfAggression=" + levelOfAggression +
                "} " + super.toString();
    }
}
