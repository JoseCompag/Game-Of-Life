package main;

import board.Board;
import rule.Rule;
import system.System;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System system = new System();

        ArrayList<Rule> rules = system.loadRules();
        Board board = system.loadBoard(rules);

        // system.loadObserver
        // game(board).start

    }

}
