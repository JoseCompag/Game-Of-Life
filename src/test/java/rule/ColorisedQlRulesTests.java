package rule;

import cell.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import rule.ColourisedQLGame.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import cell.ColourisedQLGame.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ColorisedQlRulesTests {

  HashMapLoad hashMapLoad;

  @BeforeEach
  public void setUp() {
    this.hashMapLoad = new HashMapLoad();
  }

  static Stream<Arguments> listBirthRuleColorized() {
    return Stream.of(
      //
      arguments(List.of(new RedCell(), new DeadCell(), new DeadCell(),
        new DeadCell(), new DeadCell(), new BlueCell(), new RedCell(), new DeadCell()), new RedCell()),
      //
      arguments(List.of(new RedCell(), new BlueCell(), new GreenCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new YellowCell()),
      //
      arguments(List.of(new RedCell(), new GreenCell(), new RedCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new RedCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listBirthRuleColorized")
  void testBirthRuleColorized (List<Cell> neighborsCells, Cell cell) {

    Rule rule1 = new BirthRule();
    HashMap<Class<?>, Integer> neighbors;
    neighbors = this.hashMapLoad.loadMapOfNeighbors(neighborsCells);
    Boolean res = rule1.validate(new DeadCell(), neighbors);
    Cell cellRes = rule1.apply(new DeadCell(), neighbors);
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }

  static Stream<Arguments> listSurviveRuleColorized() {
    return Stream.of(
      //
      arguments(List.of(new RedCell(), new RedCell(), new DeadCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new BlueCell()),
      //
      arguments(List.of(new RedCell(), new BlueCell(), new DeadCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new BlueCell()),
      //
      arguments(List.of(new YellowCell(), new GreenCell(), new RedCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new BlueCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listSurviveRuleColorized")
  void testSurviveRuleColorized (List<Cell> neighborsCells, Cell cell) {
    Rule rule1 = new SurviveRule();
    HashMap<Class<?>, Integer> neighbors;
    neighbors = this.hashMapLoad.loadMapOfNeighbors(neighborsCells);
    Boolean res = rule1.validate(new BlueCell(), neighbors);
    Cell cellRes = rule1.apply(new BlueCell(), neighbors);
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }
}