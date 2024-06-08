package cell;

public class YellowCell extends Cell{

  @Override
  public String toString() {
    String yellow="\033[33m";
    String reset="\u001B[0m";
    return yellow+"■"+reset;
  }
}
