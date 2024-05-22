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
  /*
  RectangularBoard board;
  List<Rule> rules;

  @BeforeEach
  public void setUp() {
    Rule rule1 = new BirthRule(3);
    Rule rule2 = new SurviveRule(3,2);
    Rule rule3 = new DeathRule();
    List<Rule> rules = new ArrayList<>();
    rules.add(rule1);
    rules.add(rule2);
    rules.add(rule3);
    this.rules = rules;
    RectangularBoard board = new RectangularBoard(6,6,rules);
    board.setCell(1, 3, new LivingCell());
    board.setCell(1, 4, new LivingCell());
    board.setCell(2, 3, new LivingCell());
    board.setCell(2, 4, new LivingCell());
    board.setCell(3, 1, new LivingCell());
    board.setCell(3, 2, new LivingCell());
    board.setCell(4, 2, new LivingCell());
    board.setCell(4, 1, new LivingCell());
    this.board = board;
  }

  static Stream<Arguments> listBoards() {
    return Stream.of(
      //
      arguments(
          "□ □ □ □ □ □ \n" +
          "□ □ □ ■ ■ □ \n" +
          "□ □ □ □ ■ □ \n" +
          "□ ■ □ □ □ □ \n" +
          "□ ■ ■ □ □ □ \n" +
          "□ □ □ □ □ □ \n" ),
      arguments(
          "□ □ □ □ □ □ \n" +
          "□ □ □ ■ ■ □ \n" +
          "□ □ □ ■ ■ □ \n" +
          "□ ■ ■ □ □ □ \n" +
          "□ ■ ■ □ □ □ \n" +
          "□ □ □ □ □ □ \n" ),
      arguments(
          "□ □ □ □ □ □ \n" +
          "□ □ □ ■ ■ □ \n" +
          "□ □ □ □ ■ □ \n" +
          "□ ■ □ □ □ □ \n" +
          "□ ■ ■ □ □ □ \n" +
          "□ □ □ □ □ □ \n" )

      );
  }

  @ParameterizedTest
  @MethodSource("listBoards")
  void testBoard(String boards) {
    String res1 = board.toString();
    System.out.println(res1);
    board = (RectangularBoard) board.nextBoard();
    //this.board = (RectangularBoard) board.nextBoard();
    String res = board.toString();
    System.out.println(res);
    assertThat(res).isEqualTo(boards);
  }

   */
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
  @MethodSource("listBoards")
  void testNextBoard(List<String> boards, String configInitial) {

    Board board = new RectangularBoard(configInitial, 6, 6, rules);

    for (String listBoard : boards) {
      board = board.nextBoard();
      String res = board.toString();
      assertThat(res).isEqualTo(listBoard);
    }
  }

  static Stream<Arguments> listBoards() {
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





}
