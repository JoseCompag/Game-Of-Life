package game;

import board.Board;
import board.RectangularBoard;
import cell.CellFactoryTraditionalGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.TerminalOutput;
import rule.BirthRule;
import rule.DeathRule;
import rule.Rule;
import rule.SurviveRule;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HightlifeTest {

    List<Rule> rules = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        ArrayList<Integer> paramsForBirthRule = new ArrayList<>();
        paramsForBirthRule.add(3);
        paramsForBirthRule.add(6);
        Rule rule1 = new BirthRule(paramsForBirthRule);
        ArrayList<Integer> paramsForSurviveRule = new ArrayList<>();
        paramsForSurviveRule.add(3);
        paramsForSurviveRule.add(2);
        Rule rule2 = new SurviveRule(paramsForSurviveRule);
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
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ □ ■ ■ ■ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n";
        Board board = new RectangularBoard(15, 20, configInitial, rules, new CellFactoryTraditionalGame());
        Game game = new Game(board);
        TerminalOutput output = new TerminalOutput(game);
        game.start(29);
        Board newBoardGame = game.getBoard();
        String newBoard =
                        "□ □ □ □ □ ■ ■ ■ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ ■ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ ■ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ ■ □ □ ■ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ ■ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ ■ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ ■ ■ ■ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ □ ■ ■ ■ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ □ ■ □ □ □ ■ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ ■ □ □ □ □ ■ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ ■ □ □ ■ □ □ ■ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ ■ □ □ □ □ ■ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ ■ □ □ □ ■ □ □ □ □ □ \n" +
                        "□ □ □ □ □ □ □ □ □ □ □ ■ ■ ■ □ □ □ □ □ □ "+"\n";

        Boolean res = newBoard.equals(newBoardGame.toString());
        assertThat(res).isTrue();
    }

}
