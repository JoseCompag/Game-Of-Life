package cell;

public class DeadCellFactory extends CellFactory {

  @Override
  public Cell createCell() {
    return new DeadCell();
  }

}
