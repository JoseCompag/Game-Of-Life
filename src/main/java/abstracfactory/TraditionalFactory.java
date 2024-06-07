package abstracfactory;

import board.Board;
import board.BoardFactory;
import board.RectangularBoard;
import cell.CellFactory;
import cell.CellFactoryTraditionalGame;
import rule.BirthRule;
import rule.Rule;
import rule.RuleFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraditionalFactory implements AbstracFactory{

    @Override
    public Board createBoardFactory(Integer rows, Integer cols, String configInitial) {
        CellFactory cellFactory = new CellFactoryTraditionalGame();
        Board board = new RectangularBoard(rows, cols, configInitial, cellFactory);
        return board;
    }

    @Override
    public List<Rule> createRuleFactory() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRule(Arrays.asList(2,3));


        return null;
    }
}

/*
pensar pon donde tengo que pasar los parametros de tod lo que ncesito
 */
