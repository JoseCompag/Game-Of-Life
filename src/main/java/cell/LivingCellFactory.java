package cell;

public class LivingCellFactory extends CellFactory {
  public LivingCellFactory() {  }


  @Override
  public Cell createCell() {
    return new LivingCell();
  }
}
