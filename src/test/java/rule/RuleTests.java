package rule;

import cell.Cell;
import cell.TraditionalGame.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import rule.TraditionalGame.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RuleTests {

  static Stream<Arguments> listSurviveRule() {
    return Stream.of(
            //
            arguments(List.of(new LivingCell(), new LivingCell()), new LivingCell()),
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new LivingCell()), new LivingCell())
            //
            );
  }

  @ParameterizedTest
  @MethodSource("listSurviveRule")
  void testSurviveRule (List<Cell> cells, Cell cell) {

    Rule rule1 = new SurviveRule();
    Cell initialCell = new LivingCell();
    HashMap<Cell, List<Cell>> surviveRule = new HashMap<>();
    surviveRule.put(initialCell, cells);
    rule1.setCells(surviveRule);
    Cell cellRes = rule1.apply(initialCell);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }

  static Stream<Arguments> listBirthRule() {
    return Stream.of(
      //
      arguments(List.of(new LivingCell(), new LivingCell(), new LivingCell()), new LivingCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listBirthRule")
  void testBirthRule (List<Cell> cells, Cell cell) {
    Rule rule1 = new BirthRule();
    Cell initialCell = new DeadCell();
    HashMap<Cell, List<Cell>> surviveRule = new HashMap<>();
    surviveRule.put(initialCell, cells);
    rule1.setCells(surviveRule);
    Cell cellRes = rule1.apply(initialCell);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }

}
