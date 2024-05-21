package rule;

import board.Board;
import board.RectangularBoard;
import cell.Cell;
import cell.DeadCell;
import cell.LivingCell;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RuleTests {

  static Stream<Arguments> listRules() {
    return Stream.of(
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), LivingCell.class),
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new LivingCell(), new DeadCell()), LivingCell.class),
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new LivingCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), LivingCell.class)
            );
  }

  @ParameterizedTest
  @MethodSource("listRules")
  void testSurviveRule(List<Cell> cells, Cell cell) {
    Rule rule1 = new SurviveRule(2, 3);
    Boolean res = rule1.validate(cells);
    Cell cellRes = rule1.apply();
    assertThat(res).isEqualTo(true);
    assertThat(cellRes).isEqualTo(cell);

  }
}
