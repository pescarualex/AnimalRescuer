package org.fasttrackit;

import org.fasttrackit.service.Game;

public class App {
    public static void main( String[] args ) throws InterruptedException {

        Game play = new Game();
        play.start();
    }
}