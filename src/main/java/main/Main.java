package main;

import game.Game;

public class Main {

    public static void main (String[] args) {
        String s = "configColorised15x20.properties";
        Game game = new Game(s);
        game.start();
    }

}