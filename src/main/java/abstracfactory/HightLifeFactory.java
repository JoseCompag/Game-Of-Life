package abstracfactory;

import board.Board;
import board.RectangularBoard;
import cell.CellFactory;
import cell.CellFactoryTraditionalGame;
import rule.BirthRule;
import rule.DeathRule;
import rule.Rule;
import rule.SurviveRule;

import java.util.ArrayList;
import java.util.List;

public class HightLifeFactory implements AbstracFactory {

    public HightLifeFactory(){}

    @Override
    public Board createBoard(Integer rows, Integer cols, String configInitial) {
        CellFactory cellFactory = new CellFactoryTraditionalGame();
        Board board = new RectangularBoard(rows, cols, configInitial, cellFactory);
        return board;
    }

    @Override
    public List<Rule> createRule() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRule(List.of(3,6));
        Rule rule2 = new SurviveRule(List.of(2,3));
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        return rules;
    }
}
