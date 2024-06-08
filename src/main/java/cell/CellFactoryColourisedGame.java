package cell;

public class CellFactoryColourisedGame extends CellFactory {

  public CellFactoryColourisedGame() {}

  @Override
  public Cell createCell(Character symbol) {

    switch (symbol) {
      case 'Y':
        return new YellowCell();
      case 'G':
        return new GreenCell();
      case 'B':
        return new BlueCell();
      case 'R':
        return new RedCell();
    }

    return new DeadCell();
  }
}
