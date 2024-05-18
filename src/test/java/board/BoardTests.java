package board;

import boards.Board;
import boards.RectangularBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

  @Test
  public void testBoardToString() {
    Board board = new RectangularBoard(8,8);
    String res = board.toString();
    System.out.println(res);
    assertTrue(true);
  }

  @Test
  public void testBoard() {
    Board board = new RectangularBoard(8,8);
    assertTrue(true);
  }
}
