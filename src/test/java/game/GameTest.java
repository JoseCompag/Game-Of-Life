package game;

import board.Board;
import board.RectangularBoard;
import org.junit.jupiter.api.Test;
import rule.Rule;
import rule.Rule1;
import rule.Rule2;
import rule.Rule3;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class GameTest {

  @Test
  public void testGame() {
    Board board = new RectangularBoard(8, 8);
    Rule rule1 = new Rule1();
    Rule rule2 = new Rule2();
    Rule rule3 = new Rule3();
    List<Rule> rules = new ArrayList<Rule>();
    rules.add(rule1);
    rules.add(rule2);
    rules.add(rule3);

  }
}
