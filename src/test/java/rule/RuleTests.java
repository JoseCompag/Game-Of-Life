package rule;

import boards.Board;
import boards.RectangularBoard;
import org.junit.jupiter.api.Test;
import rules.Rule;
import rules.Rule1;
import rules.Rule2;
import rules.Rule3;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RuleTests {

  @Test
  void testRule() {
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
