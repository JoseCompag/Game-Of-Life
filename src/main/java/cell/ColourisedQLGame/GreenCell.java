package cell.ColourisedQLGame;

import cell.Cell;

public class GreenCell extends Cell {

  @Override
  public String toString() {
    String green="\033[32m";
    String reset="\u001B[0m";
    return green+"■"+reset;
  }
}
