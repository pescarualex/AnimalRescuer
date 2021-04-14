package org.fasttrackit.domain.animals;

public class Cat extends  Animal{

        private int sleepADay;

        public Cat(String name, String breed, int age) {
                super(name, breed, age);
        }

        public Cat() {
        }


        @Override
        public Cat dysplayAnimalMood() {
                System.out.println("The mood level is increase. The cat began to spin. So cute!!");
                return this;
        }

        public int getSleepADay() {
                return sleepADay;
        }

        public void setSleepADay(int sleepADay) {
                this.sleepADay = sleepADay;
        }

        @Override
        public String toString() {
                return "Cat{" +
                        "sleepADay=" + sleepADay +
                        "} " + super.toString();
        }
}
