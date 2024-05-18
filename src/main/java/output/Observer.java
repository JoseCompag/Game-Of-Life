package output;

import boards.Board;

import java.util.Observable;

public interface Observer {
  public void update(Board board, Integer generation);
}
