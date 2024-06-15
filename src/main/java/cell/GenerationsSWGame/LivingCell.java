package cell.GenerationsSWGame;

import cell.Cell;

public class LivingCell extends Cell {

  @Override
  public String toString() {
    String yellow="\033[33m";
    String reset="\u001B[0m";
    return yellow+"■"+reset;
  }

}
