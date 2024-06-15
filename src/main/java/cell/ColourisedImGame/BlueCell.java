package cell.ColourisedImGame;

import cell.Cell;

public class BlueCell extends Cell {

  @Override
  public String toString() {
    String blue="\033[34m";
    String reset="\u001B[0m";
    return blue+"■"+reset;
  }
}
