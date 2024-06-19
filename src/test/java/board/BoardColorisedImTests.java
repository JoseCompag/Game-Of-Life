package board;

import cell.ColourisedImGame.CellFactoryColourisedImGame;

import org.junit.jupiter.api.BeforeEach;
import rule.ColourisedImGame.*;
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


public class BoardColorisedImTests {

    static String blue="\033[34m";
    static String red="\033[31m";
    static String reset="\u001B[0m";
    static String b = blue+"■"+reset;
    static String r = red+"■"+reset;


    List<Rule> rules = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Rule rule1 = new BirthRule();
        Rule rule2 = new SurviveRule();
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
    }

    @Test
    void testBoard() {
        String expected =
                "□ □ □ □ □ □ \n" +
                        "□ □ □ "+r+" "+r+" □ \n" +
                        "□ □ □ "+r+" "+r+" □ \n" +
                        "□ "+b+" "+b+" □ □ □ \n" +
                        "□ "+b+" "+b+" □ □ □ \n" +
                        "□ □ □ □ □ □ "+"\n";
        String configInitial =
                "□ □ □ □ □ □ \n" +
                        "□ □ □ R R □ \n" +
                        "□ □ □ R R □ \n" +
                        "□ B B □ □ □ \n" +
                        "□ B B □ □ □ \n" +
                        "□ □ □ □ □ □ "+"\n";
        System.out.println(expected);
        Board board = new RectangularBoard(6, 6, configInitial, new CellFactoryColourisedImGame());
        board.setRules(new ArrayList<Rule>());
        String res = board.toString();
        System.out.println(res);
        assertThat(expected).isEqualTo(res);
    }

    @ParameterizedTest
    @MethodSource("listBoardColorized1")
    void testListBoards2(List<String> boards, String configInitial) {
        Board board = new RectangularBoard(15, 20, configInitial, new CellFactoryColourisedImGame());
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
                                "□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ "+"\n")

        );
    }

}