package cell;

public class LivingCellFactory extends CellFactory {

  @Override
  public Cell createCell() {
    return new LivingCell();
  }

}
