package output;

import board.Board;
import game.Game;

public class Output implements Observer{

  private Game game;

  public Output(Game game) {
    this.game = game;
    game.registerObserver(this);
  }

  @Override
  public void update(Board board, Integer generation) {
    String print = board.toString();
    System.out.println("---"+generation+"---");
    System.out.println(print);
  }
}
