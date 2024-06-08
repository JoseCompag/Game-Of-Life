package output;

import board.Board;
import board.RectangularBoard;
import game.GameController;
import org.junit.jupiter.api.*;
import rule.Rule;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTests {

  @Test
  public void output() {
    Board board = new RectangularBoard(8, 8);
    board.setRules(new ArrayList<Rule>());
    GameController game = new GameController(board);
    MockOutput mockOutput = new MockOutput(game);
    game.start(5);
    assertThat(mockOutput.isInvoked()).isTrue();
    assertThat(mockOutput.getGeneration()).isEqualTo(5);
  }

}
