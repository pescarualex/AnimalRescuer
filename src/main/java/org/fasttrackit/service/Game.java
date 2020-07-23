package org.fasttrackit.service;

import org.fasttrackit.controler.StdInControler;
import org.fasttrackit.controler.utils.ScannerUtils;
import org.fasttrackit.domain.AnimalFood;
import org.fasttrackit.domain.RecreationActivity;
import org.fasttrackit.domain.Rescuer;
import org.fasttrackit.domain.animals.Animal;
import org.fasttrackit.domain.animals.Cat;
import org.fasttrackit.domain.animals.Dog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {

    StdInControler controler = new StdInControler();

    Rescuer rescuer = new Rescuer();
    Animal dog;
    Animal cat;
    Animal animal;
    AnimalFood food;
    RecreationActivity activity;
    int x = 0;

    private int countTheRound = 1;
    private boolean winnerNotKnow = true;

    private List<AnimalFood> availableFoods = new ArrayList<>();
    private RecreationActivity[] availableActivitys = new RecreationActivity[5];

    public void start() throws InterruptedException {
        System.out.println("Welcome to the Animal Rescuer game!");
        System.out.println();

        initRescuer(rescuer);

        System.out.println();
        System.out.println("There are abandoned just cats and dogs.");

        selectAnAnimal();

        System.out.println("Let's go home now!");
        TimeUnit.SECONDS.sleep(1);


        while (countTheRound < 6 && winnerNotKnow) {
            playOneRound();
        }

        if (winnerNotKnow) {
            System.out.println();
            System.out.println("You lost the game. Try again!\n" +
                    "Hunger level is " + animal.getHungerLevel() + "\n" +
                    "Mood level is " + animal.getMoodLevel());
        }


    }

    private void playOneRound() throws InterruptedException {
        System.out.println();
        System.out.println("What do you want?\n" +
                "1. Give some food to eat\n" +
                "2. Play an activity");


        int getChooiseFromUser = ScannerUtils.readNextSingleInt();
        System.out.println();
        System.out.println("Round " + countTheRound++);
        if (getChooiseFromUser == 1) {
            requireFeeding();
        } else {
            requireActivity();
        }

        if (animal.getHungerLevel() >= 8 && animal.getMoodLevel() >= 8) {
            System.out.println();
            System.out.println("You win the game! Congratz!\n" +
                    "Hunger level is " + animal.getHungerLevel() + "\n" +
                    "Mood level is " + animal.getMoodLevel());
            winnerNotKnow = false;
        }
    }


    private void requireFeeding() throws InterruptedException {
        System.out.println("Do you want to give something to eat to " + animal.getName() + "?(Y/N)");
        String selectAnswer = ScannerUtils.readNextSingleLine();

        if (selectAnswer.equalsIgnoreCase("Y")) {
            initFood();
            rescuer.feeding(animal, getFoodFromUser(food));
        } else if (selectAnswer.equalsIgnoreCase("N")) {
            System.out.println("You want to eat..ok.");
        }
    }

    private void requireActivity() throws InterruptedException {
        System.out.println("Do you want to play a game with " + animal.getName() + "?(Y/N)");
        String selectAnswer = ScannerUtils.readNextSingleLine();

        if (selectAnswer.equalsIgnoreCase("Y")) {
            initActivity();
            rescuer.playActivity(animal, getActivityFromUser(activity));
        } else if (selectAnswer.equalsIgnoreCase("N")) {
            System.out.println("Ohh, you are lazy.. ");
        }
    }

    private AnimalFood getFoodFromUser( AnimalFood food) {
        this.food = food;
        for (AnimalFood dish : availableFoods) {
            System.out.println("What you give?");
            int chooseFood = ScannerUtils.readNextSingleInt();
            if (chooseFood == 1) {
                food = availableFoods.get(0);
            } else if (chooseFood == 2) {
                food = availableFoods.get(1);
            } else if (chooseFood == 3) {
                food = availableFoods.get(2);
            } else if (chooseFood == 4) {
                food = availableFoods.get(3);
            } else if (chooseFood == 5) {
                food = availableFoods.get(4);
            } else if (chooseFood == 6) {
                food = availableFoods.get(5);
            }
            return food;
        }
        return food;
    }

    private RecreationActivity getActivityFromUser(RecreationActivity activity) {
        this.activity = activity;
        System.out.println("What activity want to play with " + animal.getName() + "?");
        int chooseActivity = ScannerUtils.readNextSingleInt();
        if (chooseActivity == 1) {
            activity = availableActivitys[0];
        } else if (chooseActivity == 2) {
            activity = availableActivitys[1];
        } else if (chooseActivity == 3) {
            activity = availableActivitys[2];
        } else if (chooseActivity == 4) {
            activity = availableActivitys[3];
        } else if (chooseActivity == 5) {
            activity = availableActivitys[4];
        }
        return activity;
    }


    public String getNameOfAnimal() {
        return controler.getNameOfAnimal();
    }

    private Rescuer initRescuer(Rescuer rescuer) {
        this.rescuer = rescuer;

        System.out.println("Please enter the name of rescuer: ");

        rescuer.setName(ScannerUtils.readNextSingleLine());

        if (!rescuer.getName().matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid name.");
            initRescuer(rescuer);
        }

        return rescuer;
    }


    private void selectAnAnimal() {

        System.out.println("Which type of animal do you prefer?(Please enter the number)");
        System.out.println("1. Dog");
        System.out.println("2. Cat");


        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            if (i == 1) {
                animal = initDog();
                System.out.println("Your animal is a Dog, named: " + animal.getName());

            } else {
                animal = initCat();
                System.out.println("Your animal is a Cat, named: " + animal.getName());
            }
        } catch (InputMismatchException e) {
            System.out.println("You enterd invalid option");
            selectAnAnimal();
        }
    }

    private Animal initDog() {
        dog = new Dog();
        System.out.println("What name want to give him? ");
        dog.setName(getNameOfAnimal());
        dog.setBreed("German BRAC");
        dog.setAge(5);
        dog.setGender("Male");
        dog.setFavoriteFood("Dry food");
        dog.setFavoriteRecreationActivity("Running after the ball");
        dog.setHealthLevel(5);
        dog.setHungerLevel(3);
        dog.setMoodLevel(4);

        return dog;
    }

    private Animal initCat() {
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

        return cat;
    }


    private void initFood() throws InterruptedException {
        if (x == 0) {
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

            x = 1;
        }


        displayFood();
    }


    private void displayFood() throws InterruptedException {
        System.out.println("I have this: ");

        int count = 0;

        for (AnimalFood food : availableFoods) {
            count++;
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(count + ". " + food.getName());
        }
    }


    private void initActivity() throws InterruptedException {
        RecreationActivity recreationActivity = new RecreationActivity();
        recreationActivity.setName("Running after the ball");

        RecreationActivity secondRecreationActivity = new RecreationActivity();
        secondRecreationActivity.setName("It spins after the tail");

        RecreationActivity thirdRecreationActivity = new RecreationActivity();
        thirdRecreationActivity.setName("It smells like traces");

        RecreationActivity fourActivity = new RecreationActivity();
        fourActivity.setName("Capnit toys");

        RecreationActivity fiveActivity = new RecreationActivity();
        fiveActivity.setName("Play with toys");

        availableActivitys[0] = recreationActivity;
        availableActivitys[1] = secondRecreationActivity;
        availableActivitys[2] = thirdRecreationActivity;
        availableActivitys[3] = fourActivity;
        availableActivitys[4] = fiveActivity;

        displayActivity();

    }

    private void displayActivity() throws InterruptedException {
        System.out.println("Available activity: ");

        for (int i = 0; i < availableActivitys.length; i++) {
            TimeUnit.MILLISECONDS.sleep(200);
            if (availableActivitys[i] != null) {
                System.out.println(i + 1 + ". " + availableActivitys[i].getName());
            }
        }
    }

}
