package org.fasttrackit.service;

import org.fasttrackit.controler.StdInControler;
import org.fasttrackit.controler.utils.ScannerUtils;
import org.fasttrackit.domain.AnimalFood;
import org.fasttrackit.domain.AnimalsShop;
import org.fasttrackit.domain.RecreationActivity;
import org.fasttrackit.domain.Rescuer;
import org.fasttrackit.domain.animals.Animal;
import org.fasttrackit.domain.animals.Cat;
import org.fasttrackit.domain.animals.Dog;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Game {

    StdInControler controler = new StdInControler();

    Rescuer rescuer = new Rescuer();
    Animal dog;
    Animal cat;
    Animal animal;
    AnimalFood food;
    RecreationActivity activity;

    private int countTheRound = 1;
    private boolean winnerNotKnow = true;

    private final List<AnimalFood> availableFoods = new ArrayList<>();
    private final RecreationActivity[] availableActivities = new RecreationActivity[5];
    private final Set<AnimalsShop> animalsShops = new HashSet<>();

    public void start() throws InterruptedException {
        System.out.println("Welcome to the Animal Rescuer game!");
        System.out.println();

        initFood();
        initActivity();

        initRescuer(rescuer);

        System.out.println();
        System.out.println("There are abandoned just cats and dogs.");

        selectAnAnimal();

        System.out.println("\nI want to go at the animals shop to buy you some food.");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Here we are, in the shop.\n");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Ok, let's see, what they have..");
        addFoodInTheShop();
        displayFoodInShop();

        System.out.println("I think.. hmm.. "); //finish these phrase

        //TODO: implement functionality for buying from shop (19.04.2021, 3:51 PM)



        TimeUnit.SECONDS.sleep(1);
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

    private void playOneRound() {
        System.out.println();
        System.out.println("Round " + countTheRound++ + "\n");

        System.out.println("What do you want to do?\n" +
                "1. Give some food to eat\n" +
                "2. Play an activity");

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        try {
            int getChooiseFromUser = 0;

            try {
                getChooiseFromUser = scanner.nextInt();

                if (getChooiseFromUser <= 0) {
                    System.out.println("You entered an invalid option. Try again!");
                    playOneRound();
                }
            } catch (InputMismatchException e) {
                System.out.println("You entered an invalid option. Try again!");
                playOneRound();
            }

            if (getChooiseFromUser == 1) {
                requireFeeding();
            } else if (getChooiseFromUser == 2) {
                requireActivity();
            } else {
                System.out.println("The choose do not exist. Choose again: ");
                playOneRound();
            }
        } catch (InterruptedException e) {
            System.out.println("Sorry, here is a problem.. Will be loaded again very soon.");
            playOneRound();
        }

        if (animal.getHungerLevel() >= 8 && animal.getMoodLevel() >= 8) {
            System.out.println();
            System.out.println("You win the game! Congratz!\n" +
                    "Hunger level is " + animal.getHungerLevel() + "\n" +
                    "Mood level is " + animal.getMoodLevel());
            winnerNotKnow = false;
        }

        scanner.close();
    }


    private void requireFeeding() throws InterruptedException {
        displayFood();
        rescuer.feeding(animal, getFoodFromUser(food));
    }

    private void requireActivity() throws InterruptedException {
        displayActivity();
        rescuer.playActivity(animal, getActivityFromUser(activity));
    }

    private AnimalFood getFoodFromUser(AnimalFood food) {
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
            activity = availableActivities[0];
        } else if (chooseActivity == 2) {
            activity = availableActivities[1];
        } else if (chooseActivity == 3) {
            activity = availableActivities[2];
        } else if (chooseActivity == 4) {
            activity = availableActivities[3];
        } else if (chooseActivity == 5) {
            activity = availableActivities[4];
        }
        return activity;
    }


    public String getNameOfAnimal() {
        return controler.getNameOfAnimal();
    }

    private void initRescuer(Rescuer rescuer) {
        this.rescuer = rescuer;

        System.out.println("Please enter the name of rescuer: ");
        rescuer.setName(ScannerUtils.readNextSingleLine());

        if (!rescuer.getName().matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid name.");
            initRescuer(rescuer);
        }

        System.out.println("Enter the budget: ");

        try {
            rescuer.setBudget(ScannerUtils.readNextSingleDouble());
        } catch (InputMismatchException e) {
            System.out.println("Invalid data.");
            initRescuer(rescuer);
        }
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

            } else if (i == 2) {
                animal = initCat();
                System.out.println("Your animal is a Cat, named: " + animal.getName());
            } else {
                System.out.println("This chooise is not available, try again: ");
                selectAnAnimal();
            }
        } catch (InputMismatchException e) {
            System.out.println("You entered invalid option");
            selectAnAnimal();
        }
    }

    private Animal initDog() {
        dog = new Dog();
        System.out.println("What name want to give him? ");
        dog.setName(getNameOfAnimal());

        if (!dog.getName().matches("[a-zA-Z]+")) {
            System.out.println("His name it's made of from letters, you silly.");
            initDog();
        }

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

        if (!cat.getName().matches("[a-zA-Z]+")) {
            System.out.println("His name it's made of from letters, you silly.");
            initCat();
        }

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

    private void addFoodInTheShop() {
        for (AnimalFood animalFood : availableFoods) {
            AnimalsShop animalsShop = new AnimalsShop();
            animalsShop.setFoodName(animalFood.getName());
            animalsShop.setPrice(animalFood.getPrice());
            animalsShop.setQuantity((int) animalFood.getQuantity());
            animalsShop.setExpirationDate(animalFood.getExpirationDate());

            animalsShops.add(animalsShop);

        }
    }

    private void displayFoodInShop() {
        int count = 1;
        for (AnimalsShop animalsShop : animalsShops) {
            System.out.println(count + ". " + animalsShop.getFoodName() + ", Price: " + animalsShop.getPrice() +
                    ", Quantity: " + animalsShop.getQuantity() + ", " + animalsShop.getExpirationDate());
            count++;
        }
    }


    private void initFood() {

        AnimalFood food = new AnimalFood();
        food.setName("Dry food");
        food.setPrice(50);
        food.setQuantity(5);
        food.setExpirationDate(LocalDate.of(2021, 9, 15));

        AnimalFood secondFood = new AnimalFood();
        secondFood.setName("Meet");
        secondFood.setPrice(42);
        secondFood.setQuantity(3);
        secondFood.setExpirationDate(LocalDate.of(2021, 9, 17));

        AnimalFood thirdFood = new AnimalFood();
        thirdFood.setName("Chicken");
        thirdFood.setPrice(38);
        thirdFood.setQuantity(6);
        thirdFood.setExpirationDate(LocalDate.of(2021, 7, 26));

        AnimalFood fourFood = new AnimalFood();
        fourFood.setName("Whiskas");
        fourFood.setPrice(30);
        fourFood.setQuantity(4);
        fourFood.setExpirationDate(LocalDate.of(2021, 9, 23));

        AnimalFood fiveFood = new AnimalFood();
        fiveFood.setName("Wet food");
        fiveFood.setPrice(25);
        fiveFood.setQuantity(8);
        fiveFood.setExpirationDate(LocalDate.of(2021, 10, 3));

        AnimalFood sixFood = new AnimalFood();
        sixFood.setName("Chiken in souce");
        sixFood.setPrice(65);
        sixFood.setQuantity(6);
        sixFood.setExpirationDate(LocalDate.of(2021, 11, 9));

        availableFoods.add(food);
        availableFoods.add(secondFood);
        availableFoods.add(thirdFood);
        availableFoods.add(fourFood);
        availableFoods.add(fiveFood);
        availableFoods.add(sixFood);


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


    private void initActivity() {
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

        availableActivities[0] = recreationActivity;
        availableActivities[1] = secondRecreationActivity;
        availableActivities[2] = thirdRecreationActivity;
        availableActivities[3] = fourActivity;
        availableActivities[4] = fiveActivity;

    }

    private void displayActivity() throws InterruptedException {
        System.out.println("Available activity: ");

        for (int i = 0; i < availableActivities.length; i++) {
            TimeUnit.MILLISECONDS.sleep(200);
            if (availableActivities[i] != null) {
                System.out.println(i + 1 + ". " + availableActivities[i].getName());
            }
        }
    }

}
