package board;

import cell.CellFactory;
import cell.TraditionalGame.CellFactoryTraditionalGame;
import org.junit.jupiter.api.BeforeEach;
import rule.*;
import rule.TraditionalGame.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BoardTests {

  List<Rule> rules = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    ArrayList<Integer> paramsForBirthRule = new ArrayList<>();
    paramsForBirthRule.add(3);
    Rule rule1 = new BirthRule(paramsForBirthRule);
    ArrayList<Integer> paramsForSurviveRule = new ArrayList<>();
    paramsForSurviveRule.add(3);
    paramsForSurviveRule.add(2);
    Rule rule2 = new SurviveRule(paramsForSurviveRule);
    Rule rule3 = new DeathRule();
    rules.add(rule1);
    rules.add(rule2);
    rules.add(rule3);
  }

  @Test
  void testBoard() {
    String configInitial =
      "□ □ □ □ □ □ \n" +
        "□ □ □ ■ ■ □ \n" +
        "□ □ □ ■ ■ □ \n" +
        "□ ■ ■ □ □ □ \n" +
        "□ ■ ■ □ □ □ \n" +
        "□ □ □ □ □ □ "+"\n";
    Board board = new RectangularBoard(6, 6, configInitial, new CellFactoryTraditionalGame());
    board.setRules(rules);
    String res = board.toString();
    assertThat(configInitial).isEqualTo(res);
  }

  @ParameterizedTest
  @MethodSource("listBoards1")
  void testNextBoard1 (List<String> boards, String configInitial) {
    Board board = new RectangularBoard(6, 6, configInitial,  new CellFactoryTraditionalGame());
    board.setRules(rules);
    for (String listBoard : boards) {
      System.out.println(board.toString());
      board = board.nextBoard();
      String aux = board.toString();
      Boolean res = aux.equals(listBoard);
      assertThat(res).isTrue();
    }
  }

  static Stream<Arguments> listBoards1() {
    return Stream.of(
      //
      arguments(List.of(
          "□ □ □ □ □ □ \n" +
            "□ □ □ ■ ■ □ \n" +
            "□ □ □ □ ■ □ \n" +
            "□ ■ □ □ □ □ \n" +
            "□ ■ ■ □ □ □ \n" +
            "□ □ □ □ □ □ \n" ,
          "□ □ □ □ □ □ \n" +
            "□ □ □ ■ ■ □ \n" +
            "□ □ □ ■ ■ □ \n" +
            "□ ■ ■ □ □ □ \n" +
            "□ ■ ■ □ □ □ \n" +
            "□ □ □ □ □ □ \n" ,
          "□ □ □ □ □ □ \n" +
            "□ □ □ ■ ■ □ \n" +
            "□ □ □ □ ■ □ \n" +
            "□ ■ □ □ □ □ \n" +
            "□ ■ ■ □ □ □ \n" +
            "□ □ □ □ □ □ \n"
        ), "□ □ □ □ □ □ \n" +
        "□ □ □ ■ ■ □ \n" +
        "□ □ □ ■ ■ □ \n" +
        "□ ■ ■ □ □ □ \n" +
        "□ ■ ■ □ □ □ \n" +
        "□ □ □ □ □ □ "+"\n"),
      //
      arguments(List.of(
        "□ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ \n" +
          "□ □ ■ ■ ■ □ \n" +
          "□ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ \n" ,
        "□ □ □ □ □ □ \n" +
          "□ □ □ ■ □ □ \n" +
          "□ □ □ ■ □ □ \n" +
          "□ □ □ ■ □ □ \n" +
          "□ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ \n" ,
        "□ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ \n" +
          "□ □ ■ ■ ■ □ \n" +
          "□ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ \n"),
        "□ □ □ □ □ □ \n" +
        "□ □ □ ■ □ □ \n" +
        "□ □ □ ■ □ □ \n" +
        "□ □ □ ■ □ □ \n" +
        "□ □ □ □ □ □ \n" +
        "□ □ □ □ □ □ "+"\n")
    );
  }

  @ParameterizedTest
  @MethodSource("listBoards2")
  void testNextBoard2 (List<String> boards, String configInitial) {
    Board board = new RectangularBoard(8, 8, configInitial, new CellFactoryTraditionalGame());
    board.setRules(rules);
    for (String listBoard : boards) {
      System.out.println(board.toString());
      board = board.nextBoard();
      String aux = board.toString();
      Boolean res = aux.equals(listBoard);
      assertThat(res).isTrue();
    }
  }

  static Stream<Arguments> listBoards2() {
    return Stream.of(
      //
      arguments(List.of(
            "□ □ □ □ ■ □ □ □ \n" +
            "□ □ □ □ ■ □ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "■ ■ ■ □ □ ■ ■ ■ \n" +
            "□ □ ■ □ ■ □ ■ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n" +
            "□ □ □ □ ■ □ □ □ \n",

          "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ ■ ■ □ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n" +
            "□ ■ □ □ ■ □ □ □ \n" +
            "□ ■ ■ ■ □ ■ ■ ■ \n" +
            "□ □ ■ □ ■ □ □ ■ \n" +
            "□ □ □ □ ■ □ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n",

          "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ ■ ■ ■ □ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "□ ■ □ □ □ □ □ □ \n" +
            "□ ■ □ □ □ ■ ■ ■ \n" +
            "□ ■ ■ □ ■ □ □ ■ \n" +
            "□ □ □ □ ■ □ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n",

            "□ □ □ □ ■ □ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "■ ■ □ □ □ ■ ■ ■ \n" +
            "□ ■ ■ ■ ■ □ □ ■ \n" +
            "□ □ □ □ ■ □ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n",

            "□ □ □ □ ■ ■ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n" +
            "□ □ □ □ □ ■ ■ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n" +
            "■ ■ □ ■ □ ■ □ ■ \n" +
            "■ ■ ■ ■ ■ □ □ ■ \n" +
            "□ □ ■ □ □ □ □ □ \n" +
            "□ □ □ □ ■ ■ □ □ \n",

            "□ □ □ □ ■ ■ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ ■ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "■ □ □ □ □ ■ □ □ \n" +
            "■ □ □ □ ■ □ ■ □ \n" +
            "□ □ ■ □ □ ■ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n",

          "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "□ ■ □ □ ■ □ ■ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n",

          "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "□ □ □ □ ■ □ ■ □ \n" +
            "□ □ □ □ □ ■ □ □ \n" +
            "□ □ □ □ □ □ □ □ \n"
        ),
        "□ □ □ □ □ □ □ □ \n" +
          "□ □ □ ■ ■ ■ □ □ \n" +
          "□ □ □ □ □ □ □ □ \n" +
          "□ ■ □ □ □ □ ■ □ \n" +
          "□ ■ □ □ □ □ ■ □ \n" +
          "□ ■ □ □ □ □ ■ □ \n" +
          "□ □ □ ■ ■ ■ □ □ \n" +
          "□ □ □ □ □ □ □ □ "+"\n")
    );
  }

}
