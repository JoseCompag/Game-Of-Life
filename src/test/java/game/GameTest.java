package game;

import board.Board;
import board.RectangularBoard;
import org.junit.jupiter.api.Test;
import output.Output;
import rule.Rule;
import rule.StayAliveRule;
import rule.DeathRule;
import rule.BirthRule;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

  @Test
  public void testGame() {
    Rule rule1 = new StayAliveRule();
    Rule rule2 = new DeathRule();
    Rule rule3 = new BirthRule();
    List<Rule> rules = new ArrayList<Rule>();
    Board board = new RectangularBoard(8, 8,rules);
    rules.add(rule1);
    rules.add(rule2);
    rules.add(rule3);
    Game game = new Game(board);
    Output output = new Output(game);
    game.start();

  }
}
