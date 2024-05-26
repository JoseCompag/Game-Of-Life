package system;

import board.Board;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import rule.BirthRule;
import rule.DeathRule;
import rule.Rule;
import rule.SurviveRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class SystemTests {

  static Stream<Arguments> paths() {
    return Stream.of(
      //
      arguments("src/main/resources/firstConfig8x8.txt",
          "□ □ □ □ □ □ □ □ \n" +
          "□ ■ ■ □ □ ■ ■ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ ■ □ ■ ■ □ ■ □ \n" +
          "□ ■ □ ■ ■ □ ■ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ ■ ■ □ □ ■ ■ □ \n" +
          "□ □ □ □ □ □ □ □ "+"\n"),
      arguments("src/main/resources/secondConfig8x8.txt",
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ "+"\n"),
      arguments("src/main/resources/thirdConfig8x8.txt",
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ □ ■ □ □ ■ □ □ \n" +
          "□ ■ □ □ □ □ ■ □ \n" +
          "□ ■ □ □ □ □ ■ □ \n" +
          "□ □ ■ □ □ ■ □ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ "+"\n")
    );
  }

  @ParameterizedTest
  @MethodSource("paths")
  public void systemTests (String path, String expected) {
    System system = new System();
    system.setPath(path);
    system.setConfigProperties("config.properties");
    List<Rule> rulesExpected = system.buildRules();
    Board board = system.buildBoard(rulesExpected);
    List<Rule> rules = new ArrayList<>();
    rules.add(new BirthRule(2));
    rules.add(new SurviveRule(2,3));
    rules.add(new DeathRule());
    assertThat(board.toString()).isEqualTo(expected);
  }

}
