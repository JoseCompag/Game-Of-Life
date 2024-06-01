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

/*
public class ParserConfigTests {

  static Stream<Arguments> paths() {
    return Stream.of(
      //
      arguments("configTest1.properties",
          "□ □ □ □ □ □ □ □ \n" +
          "□ ■ ■ □ □ ■ ■ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ ■ □ ■ ■ □ ■ □ \n" +
          "□ ■ □ ■ ■ □ ■ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ ■ ■ □ □ ■ ■ □ \n" +
          "□ □ □ □ □ □ □ □ "+"\n"),
      arguments("configTest2.properties",
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ □ □ ■ ■ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ "+"\n"),
      arguments("configTest3.properties",
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
  public void systemTests (String configProperties, String expected) {

  }

}

 */
