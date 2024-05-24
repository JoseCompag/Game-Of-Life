package board;

import cell.CellFactory;
import cell.DeadCellFactory;
import cell.LivingCellFactory;

public class CellFactoryForBoard {

  public static boolean correctCell (Character symbol) {
    if (symbol.equals('■')) {
      return true;
    }
    if (symbol.equals('□')) {
      return true;
    }
    return false;
  }

  public static CellFactory cellFactory (Character symbol) {
    if (symbol.equals('■')) {
      return new LivingCellFactory();
    }
    return new DeadCellFactory();
  }

}
