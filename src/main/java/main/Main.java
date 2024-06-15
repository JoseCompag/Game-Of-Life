package main;

import board.Board;
import board.RectangularBoard;
import cell.CellFactoryTraditionalGame;
import gamecontroller.GameController;
import gamecontroller.OneStep;
import gamecontroller.TimeSpeed;
import output.TerminalOutput;
import rule.BirthRule;
import rule.DeathRule;
import rule.Rule;
import rule.SurviveRule;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new BirthRule(List.of(3)));
        rules.add(new SurviveRule(List.of(3,2)));
        rules.add(new DeathRule());
        String configInitial =
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ ■ ■ ■ □ □ □ ■ ■ ■ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ ■ □ □ □ □ ■ □ ■ □ □ □ □ ■ □ □ □ □ \n" +
            "□ □ □ □ ■ □ □ □ □ ■ □ ■ □ □ □ □ ■ □ □ □ □ \n" +
            "□ □ □ □ ■ □ □ □ □ ■ □ ■ □ □ □ □ ■ □ □ □ □ \n" +
            "□ □ □ □ □ □ ■ ■ ■ □ □ □ ■ ■ ■ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ ■ ■ ■ □ □ □ ■ ■ ■ □ □ □ □ □ □ \n" +
            "□ □ □ □ ■ □ □ □ □ ■ □ ■ □ □ □ □ ■ □ □ □ □ \n" +
            "□ □ □ □ ■ □ □ □ □ ■ □ ■ □ □ □ □ ■ □ □ □ □ \n" +
            "□ □ □ □ ■ □ □ □ □ ■ □ ■ □ □ □ □ ■ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ ■ ■ ■ □ □ □ ■ ■ ■ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n";
        Board board = new RectangularBoard(19, 21, configInitial, new CellFactoryTraditionalGame());
        board.setRules(rules);
        GameController controller = new TimeSpeed(board, 600);
        TerminalOutput output = new TerminalOutput(controller);
        controller.start();

    }

}
