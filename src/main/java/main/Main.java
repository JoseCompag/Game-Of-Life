package main;

import game.Game;

import java.util.Arrays;

public class Main {

    public static void main (String[] args) {
        Game game = new Game(args[0]);
        game.start();
    }

}