package cell.ColourisedQLGame;

import cell.Cell;

public class RedCell extends Cell {

  @Override
  public String toString() {
    String red="\033[31m";
    String reset="\u001B[0m";
    return red+"■"+reset;
  }
}
