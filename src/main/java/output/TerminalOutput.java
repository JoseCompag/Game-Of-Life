package output;

import board.Board;
import game.Game;

public class TerminalOutput implements Observer {

  private Game game;

  public TerminalOutput(Game game) {
    this.game = game;
    game.registerObserver (this);
  }

  @Override
  public void update (Board board, Integer generation) {
    String print = board.toString();
    System.out.println ("---"+generation+"---");
    System.out.println (print);
  }

}
