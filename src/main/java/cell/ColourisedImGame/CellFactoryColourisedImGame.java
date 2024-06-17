package cell.ColourisedImGame;

import cell.Cell;
import cell.CellFactory;
import cell.DeadCell;

public class CellFactoryColourisedImGame extends CellFactory {

  public CellFactoryColourisedImGame() {}

  @Override
  public Cell createCell(Character symbol) {
    switch (symbol) {
      case 'R':
        return new RedCell();
      case 'B':
        return new BlueCell();
    }
    return new DeadCell();
  }

}
