package board;

import cell.CellFactory;
import cell.DeadCellFactory;
import cell.LivingCellFactory;

public class CellFactoryForBoard {

  public static boolean correctCell(Character simbol){
    if (simbol.equals('■')) {
      return true;
    }
    if (simbol.equals('□')) {
      return true;
    }


    return false;
  }

  public static CellFactory cellFactory(Character simbol){
    if (simbol.equals('■')) {
      return new LivingCellFactory();
    }
    return new DeadCellFactory();
  }
}
