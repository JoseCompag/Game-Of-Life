package main;

import board.Board;
import game.Game;
import output.TerminalOutput;
import rule.Rule;
import system.System;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args) {
        System system = new System();
        system.setConfigProperties("configDefault.properties");
        system.setPath("src/main/resources/default.txt");
        ArrayList<Rule> rules = system.buildRules();
        Board board = system.buildBoard(rules);
        Game game = new Game(board);
        TerminalOutput output = new TerminalOutput(game);
        game.start(20);
    }

}
