package org.fasttrackit;

public class Dog extends Animal{

   private String waist;
   private int levelOfAggression;
   private static final int levelOfCuriozity = 8;

    public Dog(String name, String breed, int age) {
        super(name, breed, age);
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
        return levelOfCuriozity;
    }
}
