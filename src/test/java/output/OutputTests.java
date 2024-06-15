package output;

import board.Board;
import board.RectangularBoard;
import cell.CellFactoryTraditionalGame;
import gamecontroller.*;
import org.junit.jupiter.api.*;
import rule.BirthRule;
import rule.DeathRule;
import rule.Rule;
import rule.SurviveRule;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTests {

  @Test
  public void output() {
    Board board = new RectangularBoard(8, 8);
    board.setRules(new ArrayList<Rule>());
    GameController game = new StartDelimited(board, 5);
    MockOutput mockOutput = new MockOutput(game);
    game.start();
    assertThat(mockOutput.isInvoked()).isTrue();
    assertThat(mockOutput.getGeneration()).isEqualTo(5);
  }

  @Test
  public void output2() {
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
    List<Rule> rules = new ArrayList<>();
    rules.add(new SurviveRule(List.of(2,3)));
    rules.add(new BirthRule(List.of(3)));
    rules.add(new DeathRule());
    board.setRules(rules);
    GameController game = new StartDelimited(board, 5);
    FileOutput fileOutput = new FileOutput(game);
    game.start();
  }

}
