package output;

import board.Board;
import gamecontroller.GameController;

public class TerminalOutput implements Observer {

  private GameController gameController;

  public TerminalOutput (GameController gameController) {
    this.gameController = gameController;
    gameController.registerObserver(this);
  }

  @Override
  public void update (Board board, Integer generation) {
    String print = board.toString();
    System.out.println("---"+generation+"---");
    System.out.println(print);
  }

}
