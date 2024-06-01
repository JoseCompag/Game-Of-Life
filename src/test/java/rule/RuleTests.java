package rule;

import cell.Cell;
import cell.DeadCell;
import cell.LivingCell;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
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
    ArrayList<Integer> params = new ArrayList<>();
    params.add(0,2);
    params.add(1,3);
    Rule rule1 = new SurviveRule(params);
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
    ArrayList<Integer> params = new ArrayList<>();
    params.add(4);
    Rule rule1 = new BirthRule(params);
    Boolean res = rule1.validate(new DeadCell(), cells);
    Cell cellRes = rule1.apply();
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }

}
