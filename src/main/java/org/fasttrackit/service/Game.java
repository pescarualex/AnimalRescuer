package org.fasttrackit.service;

import org.fasttrackit.controler.StdInControler;
import org.fasttrackit.controler.utils.ScannerUtils;
import org.fasttrackit.domain.AnimalFood;
import org.fasttrackit.domain.RecreationActivity;
import org.fasttrackit.domain.Rescuer;
import org.fasttrackit.domain.animals.Animal;
import org.fasttrackit.domain.animals.Cat;
import org.fasttrackit.domain.animals.Dog;
import java.util.concurrent.TimeUnit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Game {

    int countInputTimes = 1;


    StdInControler controler = new StdInControler();
    Rescuer rescuer = new Rescuer();
    Animal dog;
    Animal cat;


    private List<AnimalFood> availableFoods = new ArrayList<>();
    private RecreationActivity[] availableActivitys = new RecreationActivity[3];


    public void start() throws InterruptedException {
        System.out.println("Welcome to the Animal Rescuer game!");
        System.out.println();

        initRescuer(rescuer);

        System.out.println();
        System.out.println("There are abandoned just cats and dogs. \n" +
                "Which do you prefer? ");

        selectAnAnimal();

        System.out.println("Let's go home now!");
        TimeUnit.SECONDS.sleep(2);

        requireFeeding();

    }


    private void requireFeeding() throws InterruptedException {
        System.out.println();

        System.out.println("I got home. \n" +
                "Do you want to give some food to eat?(y/n)");
        String selectAnswer = ScannerUtils.readNextSingleLine();

        if (selectAnswer.equalsIgnoreCase("Y")) {
            initFood();
        } else if (selectAnswer.equalsIgnoreCase("N")) {
            System.out.println("Ok.. Do you want to play a game?(y/n)");
                String selectAnswerForPlaying = ScannerUtils.readNextSingleLine();
            if (selectAnswerForPlaying.equalsIgnoreCase("Y")) {
                requirePlayActivity();
            } else if (selectAnswerForPlaying.equalsIgnoreCase("N")) {
                System.out.println("If you do not want to feed and play animal, \n" +
                        "That means you lost the game.\n" +
                        "Goodbye! :)");
            }
        }
    }


        private void requirePlayActivity () {
            initActivity();
        }

        public String getNameOfAnimal () {
            return controler.getNameOfAnimal();
        }

        private Rescuer initRescuer (Rescuer rescuer){
            this.rescuer = rescuer;

            System.out.println("Please enter the name of rescuer: ");

            rescuer.setName(ScannerUtils.readNextSingleLine());

            if (!rescuer.getName().matches("[a-zA-Z]+")) {
                System.out.println("Please enter a valid name.");
                initRescuer(rescuer);
            }

            return rescuer;
        }


        private void selectAnAnimal () {
            countInputTimes++;

            String choosseAnimal = ScannerUtils.readNextSingleLine();


            if (choosseAnimal.equalsIgnoreCase("cat")) {
                initCat();
            } else if (choosseAnimal.equalsIgnoreCase("dog")) {
                initDog();
            } else {
                System.out.println("We don't have that..\n" +
                        "Cats and dogs, just that.");

                if (countInputTimes > 5) {
                    System.out.println("If you not understand, \n" +
                            "Goodbye!!!");
                    System.exit(0);
                }

                selectAnAnimal();
            }
        }

        private void initDog () {
            dog = new Dog();
            System.out.println("What name want to give him? ");
            dog.setName(getNameOfAnimal());
            dog.setBreed("German BRAC");
            dog.setAge(5);
            dog.setGender("Male");
            dog.setFavoriteFood("Dry food");
            dog.setFavoriteRecreationActivity("Running after the ball.");
            dog.setHealthLevel(5);
            dog.setHungerLevel(3);
            dog.setMoodLevel(4);

        }

        private void initCat () {
            cat = new Cat();
            System.out.println("What name want to give him? ");
            cat.setName(getNameOfAnimal());
            cat.setBreed("British Shorthair");
            cat.setAge(3);
            cat.setGender("Female");
            cat.setFavoriteFood("Whiskas");
            cat.setFavoriteRecreationActivity("Capnit toys");
            cat.setHealthLevel(3);
            cat.setHungerLevel(3);
            cat.setMoodLevel(4);

        }


        private void initFood () throws InterruptedException {
            AnimalFood food = new AnimalFood();
            food.setName("Dry food");
            food.setPrice(50);
            food.setQuantity(5);
            food.setExpirationDate(LocalDate.of(2020, 9, 15));

            AnimalFood secondFood = new AnimalFood();
            secondFood.setName("Meet");
            secondFood.setPrice(42);
            secondFood.setQuantity(3);
            secondFood.setExpirationDate(LocalDate.of(2020, 9, 17));

            AnimalFood thirdFood = new AnimalFood();
            thirdFood.setName("Chicken");
            thirdFood.setPrice(38);
            thirdFood.setQuantity(6);
            thirdFood.setExpirationDate(LocalDate.of(2020, 7, 26));

            AnimalFood fourFood = new AnimalFood();
            fourFood.setName("Whiskas");
            fourFood.setPrice(30);
            fourFood.setQuantity(4);
            fourFood.setExpirationDate(LocalDate.of(2020, 9, 23));

            AnimalFood fiveFood = new AnimalFood();
            fiveFood.setName("Wet food");
            fiveFood.setPrice(25);
            fiveFood.setQuantity(8);
            fiveFood.setExpirationDate(LocalDate.of(2020, 10, 3));

            AnimalFood sixFood = new AnimalFood();
            sixFood.setName("Chiken in souce");
            sixFood.setPrice(65);
            sixFood.setQuantity(6);
            sixFood.setExpirationDate(LocalDate.of(2020, 11, 9));

            availableFoods.add(food);
            availableFoods.add(secondFood);
            availableFoods.add(thirdFood);
            availableFoods.add(fourFood);
            availableFoods.add(fiveFood);
            availableFoods.add(sixFood);

            displayFood();
        }


        private void displayFood () throws InterruptedException {
            System.out.println("I have this: ");

            int count = 0;

            for (AnimalFood food : availableFoods) {
                count++;
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(count + ". " + food.getName());
            }
        }


        private void initActivity () {
            RecreationActivity recreationActivity = new RecreationActivity();
            recreationActivity.setName("Running after the ball");

            RecreationActivity secondRecreationActivity = new RecreationActivity();
            secondRecreationActivity.setName("It spins after the tail");

            RecreationActivity thirdRecreationActivity = new RecreationActivity();
            thirdRecreationActivity.setName("It smells like traces");

            availableActivitys[0] = recreationActivity;
            availableActivitys[1] = secondRecreationActivity;
            availableActivitys[2] = thirdRecreationActivity;

            displayActivity();

        }

        private void displayActivity () {
            System.out.println("Available activity: ");

            for (int i = 0; i < availableActivitys.length; i++) {
                if (availableActivitys[i] != null) {
                    System.out.println(i + 1 + ". " + availableActivitys[i].getName());
                }
            }
        }

}
