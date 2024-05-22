package cell;

public class DeadCellFactory extends CellFactory {

  public DeadCellFactory() {}

  @Override
  public Cell createCell() {
    return new DeadCell();
  }
}
