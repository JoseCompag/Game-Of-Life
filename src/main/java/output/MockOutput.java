package output;

import board.Board;
import game.Game;

public class MockOutput implements Observer {

  private boolean invoked = false;
  private Game game;
  private Board board;
  private Integer generation;

  public MockOutput(Game game) {
    this.game = game;
    game.registerObserver(this);
  }

  @Override
  public void update(Board board, Integer generation) {
    this.board = board;
    this.generation = generation;
    invoked = true;
  }

  public boolean isInvoked() {
    return invoked;
  }

  public Board getBoard() {
    return board;
  }

  public Integer getGeneration() {
    return generation;
  }
}
