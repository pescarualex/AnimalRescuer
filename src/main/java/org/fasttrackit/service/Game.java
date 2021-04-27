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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {

    StdInControler controller = new StdInControler();

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
    private final List<AnimalsShop> animalsShops = new ArrayList<>();
    private final List<AnimalFood> foodBought = new ArrayList<>();

    // this throw InterruptedException because Of sleep function
    public void start() throws InterruptedException {
        System.out.println("Welcome to the Animal Rescuer game!");
        System.out.println();

        initFood();
        initActivity();
        addFoodInTheShop();

        initRescuer(rescuer);

        System.out.println();
        System.out.println("There are abandoned just cats and dogs.");

        selectAnAnimal();

        // TODO:: implement functionality which decreases from budget value of food
        //        when buying.

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

    private void playOneRound() throws InterruptedException {
        System.out.println();
        System.out.println("Round " + countTheRound++ + "\n");

        System.out.println("What do you want to do?\n" +
                "1. Give some food to eat\n" +
                "2. Play an activity\n" +
                "3. Go to the shop to get food");

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int getChooseFromUser = 0;

        try {
            getChooseFromUser = scanner.nextInt();

            if (getChooseFromUser <= 0) {
                System.out.println("You entered an invalid option. Try again!");
                playOneRound();
            }
        } catch (InputMismatchException e) {
            System.out.println("You entered an invalid option. Try again!");
            playOneRound();
        }

        if (getChooseFromUser == 1) {
            requireFeeding();
        } else if (getChooseFromUser == 2) {
            requireActivity();
        } else if (getChooseFromUser == 3) {
            getFoodFromShop();
        } else {
            System.out.println("The choose do not exist. Choose again: ");
            playOneRound();
        }

        if (animal.getHungerLevel() >= 8 && animal.getMoodLevel() >= 8) {
            System.out.println();
            System.out.println("You win the game! Congrats!\n" +
                    "Hunger level is " + animal.getHungerLevel() + "\n" +
                    "Mood level is " + animal.getMoodLevel());
            winnerNotKnow = false;
        }
    }

    //throws exception because .sleep method
    private void getFoodFromShop() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Here we are, in the shop.\n");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Ok, let's see, what they have..");
        displayFoodInShop();

        System.out.println("What you want to buy? To exit, press '0'.");

        Scanner scanner = new Scanner(System.in);

        try {
            int chooseFood = scanner.nextInt();

            if (chooseFood == 1) {
                addFoodFromShopInCart(chooseFood);
            } else if (chooseFood == 2) {
                addFoodFromShopInCart(chooseFood);
            } else if (chooseFood == 3) {
                addFoodFromShopInCart(chooseFood);
            } else if (chooseFood == 4) {
                addFoodFromShopInCart(chooseFood);
            } else if (chooseFood == 5) {
                addFoodFromShopInCart(chooseFood);
            } else if (chooseFood == 6) {
                addFoodFromShopInCart(chooseFood);
            } else if (chooseFood == 0) {
                System.out.println("We can go now.");
                playOneRound();
            } else {
                System.out.println("That not match. Try again!");
                getFoodFromShop();
            }
        } catch (InputMismatchException e) {
            System.out.println("This option in not valid. Try again carefully!");
            getFoodFromShop();
        }
    }

    // adding in cart(foodBought) the food which you choosing,
    // and then the quantity if that is equal or less than in the shop
    // and change quantity in the shop
    private void addFoodFromShopInCart(int i) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        int j = 0;
        foodBought.add(j, availableFoods.get(i - 1));

        System.out.println("Ok, " + foodBought.get(j).getName() + " be. How many?");

        try {
            int howManyFood = scanner.nextInt();

            if (animalsShops.get(i - 1).getQuantity() == 0) {
                System.out.println("Sorry, we don't have any more.");
            } else {
                if (availableFoods.get(i - 1).getQuantity() > howManyFood || availableFoods.
                        get(i - 1).getQuantity() == howManyFood) {
                    //quantity is decrease in shop
                    animalsShops.get(i - 1).setQuantity(animalsShops.get(i - 1).getQuantity() - howManyFood);

                    //quantity which is buying
                    foodBought.get(j).setQuantity(howManyFood);

                    if (rescuer.getBudget() < (availableFoods.get(i - 1).getPrice() * howManyFood)) {
                        System.out.println("I can't buy this because I don't have left money for this..");
                    } else {
                        //budget is decreased
                        System.out.println("I'm buying " + howManyFood + ".");
                        rescuer.setBudget(rescuer.getBudget() - (availableFoods.get(i - 1).getPrice() * howManyFood));
                        System.out.println("I have left " + rescuer.getBudget() + "$ money.");
                    }
                } else {
                    System.out.println("Sorry, we don't have that many..");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("This option in not valid. Try again carefully!");
            getFoodFromShop();
        }

        j++;
    }



    private void requireFeeding() {
        try {
            displayFood();
        } catch (InterruptedException e) {
            System.out.println("Your data will be loaded in a moment, sorry!");
            requireFeeding();
        }

        AnimalFood animalFood = getFoodFromUser(food);
        if (animalFood != null)
            rescuer.feeding(animal, animalFood);
    }

    private void requireActivity() {
        try {
            displayActivity();
        } catch (InterruptedException e) {
            System.out.println("Your data will be loaded in a moment, sorry!");
            requireActivity();
        }

        RecreationActivity activity = new RecreationActivity();
        activity = getActivityFromUser(activity);
        if (activity != null)
            rescuer.playActivity(animal, activity);
    }

    private AnimalFood getFoodFromUser(AnimalFood food) {
        try {
            this.food = food;
            Scanner scanner = new Scanner(System.in);
            System.out.println("What you give?");
            int chooseFood = scanner.nextInt();

            switch (chooseFood) {
                case 1:
                    food = availableFoods.get(0);
                    break;
                case 2:
                    food = availableFoods.get(1);
                    break;
                case 3:
                    food = availableFoods.get(2);
                    break;
                case 4:
                    food = availableFoods.get(3);
                    break;
                case 5:
                    food = availableFoods.get(4);
                    break;
                case 6:
                    food = availableFoods.get(5);
                    break;
                default:
                    System.out.println("These option is not available. Try again!");
                    return null;
            }
        } catch (InputMismatchException e) {
            System.out.println("These option is not available. Try again!");
            return null;
        }

        return food;
    }

    private RecreationActivity getActivityFromUser(RecreationActivity activity) {
        try {
            this.activity = activity;
            Scanner scanner = new Scanner(System.in);
            System.out.println("What activity want to play with " + animal.getName() + "?");
            int chooseActivity = scanner.nextInt();

            switch (chooseActivity) {
                case 1:
                    activity = availableActivities[0];
                    break;
                case 2:
                    activity = availableActivities[1];
                    break;
                case 3:
                    activity = availableActivities[2];
                    break;
                case 4:
                    activity = availableActivities[3];
                    break;
                case 5:
                    activity = availableActivities[4];
                    break;
                default:
                    System.out.println("These option is not available. Try again!");
                    return null;
            }
        } catch (InputMismatchException e) {
            System.out.println("These option is not available. Try again!");
            return null;
        }
        return activity;
    }


    public String getNameOfAnimal() {
        return controller.getNameOfAnimal();
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

        Scanner scanner = new Scanner(System.in);

        try {
            int i = scanner.nextInt();

            if (i == 1) {
                animal = initDog();
                System.out.println("Your animal is a Dog, named: " + animal.getName());

            } else if (i == 2) {
                animal = initCat();
                System.out.println("Your animal is a Cat, named: " + animal.getName());
            } else {
                System.out.println("This choose is not available, try again: ");
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

        dog.setBreed("German BRACT");
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

        cat.setBreed("British Shorthaired");
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
                    ", Quantity: " + animalsShop.getQuantity() + ", Expiration date: " + animalsShop.getExpirationDate());
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
        sixFood.setName("Chicken in sauce");
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

    //display food from list which buying from shop
    private void displayFood() throws InterruptedException {
        System.out.println("I have this: ");

        int count = 0;

        for (AnimalFood food : foodBought) {
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
