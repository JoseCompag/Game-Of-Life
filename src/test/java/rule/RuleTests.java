package rule;

import cell.Cell;
import cell.TraditionalGame.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import rule.TraditionalGame.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RuleTests {

  HashMapLoad hashMapLoad;

  @BeforeEach
  public void setUp() {
      this.hashMapLoad = new HashMapLoad();
  }

  static Stream<Arguments> listSurviveRule() {
    return Stream.of(
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new LivingCell()),
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new LivingCell(), new DeadCell()), new LivingCell()),
            //
            arguments(List.of(new LivingCell(), new LivingCell(), new DeadCell(),
                    new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell()), new LivingCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listSurviveRule")
  void testSurviveRule (List<Cell> neighborsCells, Cell cellExpected) {
    Rule rule1 = new SurviveRule();
    HashMap<Class<?>, Integer> neighbors;
    neighbors = this.hashMapLoad.loadMapOfNeighbors(neighborsCells);

    Boolean res = rule1.validate(new LivingCell(), neighbors);
    Cell cellRes = rule1.apply(new LivingCell(), neighbors);
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cellExpected.getClass());
  }

  static Stream<Arguments> listBirthRule() {
    return Stream.of(
            //
            arguments(List.of(new LivingCell(), new DeadCell(), new LivingCell(),
                    new DeadCell(), new LivingCell(), new DeadCell(), new DeadCell(), new DeadCell()), new LivingCell()),
            //
            arguments(List.of(new LivingCell(), new DeadCell(), new DeadCell(),
                    new LivingCell(), new DeadCell(), new DeadCell(), new LivingCell(), new DeadCell()), new LivingCell()),
            //
            arguments(List.of(new LivingCell(), new DeadCell(), new LivingCell(),
                    new DeadCell(), new LivingCell(), new DeadCell(), new DeadCell(), new DeadCell()), new LivingCell())
    );
  }

  @ParameterizedTest
  @MethodSource("listBirthRule")
  void testBirthRule (List<Cell> neighborsCells, Cell cellExpected) {
    Rule rule1 = new BirthRule();
    HashMap<Class<?>, Integer> neighbors;
    neighbors = this.hashMapLoad.loadMapOfNeighbors(neighborsCells);

    Boolean res = rule1.validate(new DeadCell(), neighbors);
    Cell cellRes = rule1.apply(new DeadCell(), neighbors);
    assertThat(res).isEqualTo(true);
    assertThat(cellRes.getClass()).isEqualTo(cellExpected.getClass());
  }

}
