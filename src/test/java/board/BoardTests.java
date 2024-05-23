package board;

import board.Board;
import board.RectangularBoard;
import org.assertj.core.api.AbstractStringAssert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import rule.*;
import cell.Cell;
import cell.DeadCell;
import cell.LivingCell;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;



public class BoardTests {

  List<Rule> rules = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    Rule rule1 = new BirthRule(3);
    Rule rule2 = new SurviveRule(3,2);
    Rule rule3 = new DeathRule();
    rules.add(rule1);
    rules.add(rule2);
    rules.add(rule3);
  }

  @Test
  void testBoard(){
    String configInitial =
      "□ □ □ □ □ □ \n" +
        "□ □ □ ■ ■ □ \n" +
        "□ □ □ ■ ■ □ \n" +
        "□ ■ ■ □ □ □ \n" +
        "□ ■ ■ □ □ □ \n" +
        "□ □ □ □ □ □ "+"\n";
    Board board = new RectangularBoard(configInitial, 6, 6, rules);

    String res = board.toString();
    assertThat(configInitial).isEqualTo(res);
  }

  @ParameterizedTest
  @MethodSource("listBoards1")
  void testNextBoard1(List<String> boards, String configInitial) {

    Board board = new RectangularBoard(configInitial, 6, 6, rules);

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
  void testNextBoard2(List<String> boards, String configInitial) {

    Board board = new RectangularBoard(configInitial, 8, 8, rules);

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
