package rule;

import cell.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import rule.ColourisedImGame.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import cell.ColourisedQLGame.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ColorizedRulesTests {

  static Stream<Arguments> listBirthRuleColorized() {
    return Stream.of(
      //
      arguments(List.of(new RedCell(), new DeadCell(), new DeadCell(),
        new GreenCell(), new DeadCell(), new BlueCell(), new DeadCell(), new DeadCell()), new YellowCell()),
      //
      arguments(List.of(new RedCell(), new BlueCell(), new DeadCell(),
        new DeadCell(), new DeadCell(), new BlueCell(), new DeadCell(), new DeadCell()), new BlueCell()),
      //
      arguments(List.of(new RedCell(), new RedCell(), new RedCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()),
        new RedCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listBirthRuleColorized")
  void testBirthRuleColorized (List<Cell> cells, Cell cell) {
    ArrayList<Integer> params = new ArrayList<>();
    params.add(3);
    Rule rule1 = new BirthRule(params);
    Boolean res = rule1.validate(new DeadCell(), cells);
    Cell cellRes = rule1.apply();
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }

  static Stream<Arguments> listSurviveRuleColorized() {
    return Stream.of(
      //
      arguments(List.of(new YellowCell(), new RedCell(), new DeadCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new BlueCell()),
      //
      arguments(List.of(new YellowCell(), new DeadCell(), new DeadCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new GreenCell(), new DeadCell()), new BlueCell()),
      //
      arguments(List.of(new RedCell(), new RedCell(), new RedCell(),
        new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new BlueCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listSurviveRuleColorized")
  void testSurviveRuleColorized (List<Cell> cells, Cell cell) {
    ArrayList<Integer> params = new ArrayList<>();
    params.add(0,2);
    params.add(1,3);
    Rule rule1 = new SurviveRule(params);
    Boolean res = rule1.validate(new BlueCell(), cells);
    Cell cellRes = rule1.apply();
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cell.getClass());
  }
}
