package game;

import board.Board;
import board.RectangularBoard;
import org.junit.jupiter.api.Test;
import rule.Rule;
import rule.StayAliveRule;
import rule.DeathRule;
import rule.BirthRule;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

  @Test
  public void testGame() {
    Board board = new RectangularBoard(8, 8);
    Rule rule1 = new StayAliveRule();
    Rule rule2 = new DeathRule();
    Rule rule3 = new BirthRule();
    List<Rule> rules = new ArrayList<Rule>();
    rules.add(rule1);
    rules.add(rule2);
    rules.add(rule3);

  }
}
