package org.fasttrackit;

public class Cat extends  Animal{

        private int sleepADay;

        public Cat(String name, String breed, int age) {
                super(name, breed, age);
        }


        public int getSleepADay() {
                return sleepADay;
        }

        public void setSleepADay(int sleepADay) {
                this.sleepADay = sleepADay;
        }
}
