package abstracfactory;

import board.Board;
import board.RectangularBoard;
import cell.CellFactory;
import cell.CellFactoryTraditionalGame;
import rule.*;

import java.util.ArrayList;
import java.util.List;

public class TraditionalFactory implements AbstracFactory{

    public TraditionalFactory(){}

    @Override
    public Board createBoardFactory(Integer rows, Integer cols, String configInitial) {
        CellFactory cellFactory = new CellFactoryTraditionalGame();
        Board board = new RectangularBoard(rows, cols, configInitial, cellFactory);
        return board;
    }

    @Override
    public List<Rule> createRuleFactory() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRule(List.of(2));
        Rule rule2 = new SurviveRule(List.of(2,3));
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);

        return rules;
    }
}

/*
pensar pon donde tengo que pasar los parametros de tod lo que ncesito
 */
