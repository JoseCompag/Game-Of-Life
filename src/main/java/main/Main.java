package main;

import system.Game;

public class Main {

    public static void main (String[] args) {
        Game game = new Game("configDefault.properties", 20);
        game.start();
    }

}
