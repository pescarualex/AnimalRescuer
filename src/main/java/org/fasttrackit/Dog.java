package org.fasttrackit;

public class Dog extends Animal{

   private String waist;
   private int levelOfAggression;
   private static final int levelOfCuriozity = 8;

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
