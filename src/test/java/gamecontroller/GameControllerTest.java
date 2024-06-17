package gamecontroller;

import board.Board;
import board.RectangularBoard;
import cell.TraditionalGame.CellFactoryTraditionalGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.TerminalOutput;
import rule.*;
import rule.TraditionalGame.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {

    List<Rule> rules = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Rule rule1 = new BirthRule();
        Rule rule2 = new SurviveRule();
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
    }

    @Test
    public void testGame() {
        String configInitial =
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ ■ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ ■ □ □ □ ■ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ ■ □ □ □ □ □ ■ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ ■ □ □ □ □ □ ■ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ ■ □ □ □ □ □ ■ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ ■ □ □ □ ■ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ ■ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n";
        Board board = new RectangularBoard(15, 20, configInitial, new CellFactoryTraditionalGame());
        board.setRules(rules);
        GameController game = new Delimited(board, 10);
        TerminalOutput output = new TerminalOutput(game);
        game.start();
        Board newBoardGame = game.getBoard();
        String newBoard =
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ □ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ □ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ ■ ■ □ □ □ □ □ □ □ ■ ■ □ □ □ □ \n" +
                        "□ □ □ □ ■ □ □ ■ □ □ □ □ □ ■ □ □ ■ □ □ □ \n" +
                        "□ □ □ □ □ ■ ■ □ □ □ □ □ □ □ ■ ■ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ □ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ □ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n";
        Boolean res = newBoard.equals(newBoardGame.toString());
        assertThat(res).isTrue();
    }

    @Test
    public void testGame1() {
        String configInitial =
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ ■ ■ □ □ ■ ■ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ ■ □ ■ ■ □ ■ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ ■ □ ■ ■ □ ■ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ ■ ■ □ □ ■ ■ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n";
        Board board = new RectangularBoard(15, 20, configInitial, new CellFactoryTraditionalGame());
        board.setRules(rules);
        GameController game = new Delimited(board, 10);
        TerminalOutput output = new TerminalOutput(game);
        game.start();
        Board newBoardGame = game.getBoard();
        String newBoard =
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ ■ □ □ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ ■ □ □ ■ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ ■ ■ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n";
        Boolean res = newBoard.equals(newBoardGame.toString());
        assertThat(res).isTrue();
    }

}