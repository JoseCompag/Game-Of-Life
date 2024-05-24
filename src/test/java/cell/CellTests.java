package cell;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CellTests {

  @Test
  void DeadCellTest() {
    Cell cell = new DeadCell();
    assertThat(cell.getClass()).isEqualTo(DeadCell.class);
  }

  @Test
  void LivingCellTest() {
    Cell cell = new LivingCell();
    assertThat(cell.getClass()).isEqualTo(LivingCell.class);
  }

}
