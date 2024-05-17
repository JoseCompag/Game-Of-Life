package board;

import gameOfLife.Board;
import gameOfLife.RectangularBoard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

  @Test
  public void testBoard() {
    Board board = new RectangularBoard(8,8);
    String res = board.toString();
    System.out.println(res);
    assertTrue(true);
  }
}
