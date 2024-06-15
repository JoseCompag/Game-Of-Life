package cell.ColourisedQLGame;

import cell.Cell;
import cell.CellFactory;

public class CellFactoryColourisedQLGame extends CellFactory {

  public CellFactoryColourisedQLGame() {}

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
