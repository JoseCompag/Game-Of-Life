package output;

import board.Board;

public interface Observer {

  public void update (Board board, Integer generation);

}
