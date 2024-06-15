package cell.TraditionalHLGame;

import cell.Cell;
import cell.CellFactory;

public class CellFactoryTraditionalHLGame extends CellFactory {

  public CellFactoryTraditionalHLGame() {}

  @Override
  public Cell createCell(Character symbol) {
    if (symbol.equals('■')) {
      return new LivingCell();
    }
    return new DeadCell();
  }
}
