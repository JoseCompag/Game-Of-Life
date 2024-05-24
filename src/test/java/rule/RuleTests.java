package rule;

import cell.Cell;
import cell.DeadCell;
import cell.LivingCell;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RuleTests {

  static Stream<Arguments> listSurviveRule() {
    return Stream.of(
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new LivingCell()),
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new LivingCell(), new DeadCell()), new LivingCell()),
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new LivingCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new LivingCell())
            );
  }

  @ParameterizedTest
  @MethodSource("listSurviveRule")
  void testSurviveRule (List<Cell> cells, Cell cell) {
    Rule rule1 = new SurviveRule(2, 3);
    Boolean res = rule1.validate(new LivingCell(), cells);
    Cell cellRes = rule1.apply();
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }

  static Stream<Arguments> listBirthRule() {
    return Stream.of(
      //
      arguments(List.of(new LivingCell(), new DeadCell(), new LivingCell(),
        new DeadCell(), new LivingCell(), new DeadCell(), new DeadCell(), new LivingCell()), new LivingCell()),
      //
      arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
        new LivingCell(), new DeadCell(), new DeadCell(), new LivingCell(), new DeadCell()), new LivingCell()),
      //
      arguments(List.of(new LivingCell(), new LivingCell(), new LivingCell(),
        new DeadCell(), new LivingCell(), new DeadCell(), new DeadCell(), new DeadCell()), new LivingCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listBirthRule")
  void testBirthRule (List<Cell> cells, Cell cell) {
    Rule rule1 = new BirthRule(4);
    Boolean res = rule1.validate(new DeadCell(), cells);
    Cell cellRes = rule1.apply();
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }

}
