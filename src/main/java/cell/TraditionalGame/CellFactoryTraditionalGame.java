package cell.TraditionalGame;

import cell.Cell;
import cell.CellFactory;
import cell.DeadInitCell;

public class CellFactoryTraditionalGame extends CellFactory {

  public CellFactoryTraditionalGame() {}

  @Override
  public Cell createCell(Character symbol) {
    if (symbol.equals('■')) {
      return new LivingCell();
    }
    return new DeadInitCell();
  }
}
