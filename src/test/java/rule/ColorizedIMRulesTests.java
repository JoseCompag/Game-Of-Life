package rule;

import cell.*;
import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import cell.ColourisedImGame.*;
import rule.ColourisedIMGame.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ColorizedIMRulesTests {


  @Test
  public void testBirthRuleColorized1 () {
    Rule rule1 = new BirthRule();
    Cell initialCell = new DeadCell();
    HashMap<Cell, List<Cell>> coloredCells = new HashMap<>();
    coloredCells.put(initialCell, List.of(new BlueCell(), new RedCell(), new BlueCell()));
    rule1.setCells(coloredCells);
    Cell cellRes = rule1.apply(initialCell);
    assertThat(cellRes.getClass()).isEqualTo(BlueCell.class);
  }

  @Test
  public void testBirthRuleColorized2 () {
    Rule rule1 = new BirthRule();
    Cell initialCell = new DeadCell();
    HashMap<Cell, List<Cell>> coloredCells = new HashMap<>();
    coloredCells.put(initialCell, List.of(new RedCell(), new RedCell(), new BlueCell()));
    rule1.setCells(coloredCells);
    Cell cellRes = rule1.apply(initialCell);
    assertThat(cellRes.getClass()).isEqualTo(RedCell.class);
  }

  static Stream<Arguments> listSurviveRuleColorized() {
    return Stream.of(
      //
      arguments(List.of(new RedCell(), new BlueCell()), new RedCell()),
      //
      arguments(List.of(new RedCell(), new RedCell(), new BlueCell()), new RedCell())
      );
  }

  @ParameterizedTest
  @MethodSource("listSurviveRuleColorized")
  void testSurviveRuleColorized (List<Cell> cells, Cell cell) {
    Rule rule1 = new SurviveRule();
    Cell initialCell = new RedCell();
    HashMap<Cell, List<Cell>> coloredCells = new HashMap<>();
    coloredCells.put(initialCell, cells);
    rule1.setCells(coloredCells);
    Cell cellRes = rule1.apply(initialCell);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }
}
