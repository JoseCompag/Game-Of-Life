package game;

import board.Board;
import board.RectangularBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import output.Output;
import rule.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GameTest {

  List<Rule> rules = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    Rule rule1 = new BirthRule(3);
    Rule rule2 = new SurviveRule(3,2);
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
    Board board = new RectangularBoard(configInitial, 15, 20, rules);
    Game game = new Game(board);
    Output output = new Output(game);
    game.start(10);
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


}
