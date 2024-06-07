package output;

import board.Board;
import game.GameController;

public class TerminalOutput implements Observer {

  private GameController game;

  public TerminalOutput (GameController game) {
    this.game = game;
    game.registerObserver(this);
  }

  @Override
  public void update (Board board, Integer generation) {
    String print = board.toString();
    System.out.println("---"+generation+"---");
    System.out.println(print);
  }

}
