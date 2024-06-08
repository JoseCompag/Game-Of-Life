package board;

import cell.CellFactoryColourisedGame;
import org.junit.jupiter.api.BeforeEach;
import rule.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class BoardColorisedTests {

  static String blue="\033[34m";
  static String yellow="\033[33m";
  static String red="\033[31m";
  static String green="\033[32m";
  static String reset="\u001B[0m";
  static String y = yellow+"■"+reset;
  static String b = blue+"■"+reset;
  static String r = red+"■"+reset;
  static String g = green+"■"+reset;

  List<Rule> rules = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    ArrayList<Integer> paramsForBirthRule = new ArrayList<>();
    paramsForBirthRule.add(3);
    Rule rule1 = new BirthRuleColorised(paramsForBirthRule);
    ArrayList<Integer> paramsForSurviveRule = new ArrayList<>();
    paramsForSurviveRule.add(3);
    paramsForSurviveRule.add(2);
    Rule rule2 = new SurviveRuleColorised(paramsForSurviveRule);
    Rule rule3 = new DeathRule();
    rules.add(rule1);
    rules.add(rule2);
    rules.add(rule3);
  }

  @Test
  void testBoard() {
    String expected =
      "□ □ □ □ □ □ \n" +
        "□ "+y+" "+y+" "+r+" "+r+" □ \n" +
        "□ "+y+" "+y+" "+r+" "+r+" □ \n" +
        "□ "+b+" "+b+" "+g+" "+g+" □ \n" +
        "□ "+b+" "+b+" "+g+" "+g+" □ \n" +
        "□ □ □ □ □ □ "+"\n";
    String configInitial =
        "□ □ □ □ □ □ \n" +
        "□ Y Y R R □ \n" +
        "□ Y Y R R □ \n" +
        "□ B B G G □ \n" +
        "□ B B G G □ \n" +
        "□ □ □ □ □ □ "+"\n";
    System.out.println(expected);
    Board board = new RectangularBoard(6, 6, configInitial, new CellFactoryColourisedGame());
    board.setRules(new ArrayList<Rule>());
    String res = board.toString();
    System.out.println(res);
    assertThat(expected).isEqualTo(res);
  }

  @ParameterizedTest
  @MethodSource("listBoardColorized1")
  void testListBoards2(List<String> boards, String configInitial) {
    Board board = new RectangularBoard(15, 20, configInitial, new CellFactoryColourisedGame());
    board.setRules(rules);
    for (String listBoard : boards) {
      //System.out.println(board.toString());
      board = board.nextBoard();
      String aux = board.toString();
      System.out.println(aux);
      //System.out.println(listBoard);
      Boolean res = aux.equals(listBoard);
      assertThat(res).isTrue();
    }
  }


  static Stream<Arguments> listBoardColorized1() {
    return Stream.of(
      //
      arguments(List.of(

            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+b+" "+r+" "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+r+" "+b+" "+r+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+b+" "+r+" "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n",

          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ "+b+" □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ "+b+" □ "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ "+b+" □ □ □ "+b+" □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ "+b+" □ "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ "+b+" □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n",

            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ "+b+" □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+b+" "+b+" "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+b+" "+b+" □ "+b+" "+b+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+b+" "+b+" "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ "+b+" □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n",

            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+b+" "+b+" "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+b+" □ □ □ "+b+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+b+" □ □ □ "+b+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+b+" □ □ □ "+b+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+b+" "+b+" "+b+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n"
      ),
        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ B R B R B □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n"),
      //
      arguments(List.of(
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+g+" "+b+" "+r+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+r+" "+y+" "+g+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+g+" "+b+" "+r+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n",

          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ "+y+" □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+g+" □ "+r+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+g+" □ □ □ "+r+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+g+" □ "+r+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ "+y+" □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n",

          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ "+y+" □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+g+" "+b+" "+r+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+g+" "+g+" □ "+r+" "+r+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+g+" "+b+" "+r+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ "+y+" □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n",

          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+r+" "+y+" "+g+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+g+" □ □ □ "+r+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+g+" □ □ □ "+r+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ "+g+" □ □ □ "+r+" □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ "+r+" "+y+" "+g+" □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
            "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n"
        ),
        "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ B R Y G B □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ \n" +
          "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n")
    );
  }

}
