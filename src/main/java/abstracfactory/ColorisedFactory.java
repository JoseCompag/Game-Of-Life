package abstracfactory;

import board.Board;
import board.RectangularBoard;
import cell.CellFactory;
import cell.CellFactoryColourisedGame;
import rule.BirthRuleColorised;
import rule.DeathRule;
import rule.Rule;
import rule.SurviveRuleColorised;

import java.util.ArrayList;
import java.util.List;

public class ColorisedFactory implements AbstracFactory {

    public ColorisedFactory(){}

    @Override
    public Board createBoard(Integer rows, Integer cols, String configInitial) {
        CellFactory cellFactory = new CellFactoryColourisedGame();
        Board board = new RectangularBoard(rows, cols, configInitial, cellFactory);
        return board;
    }

    @Override
    public List<Rule> createRule() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRuleColorised(List.of(3));
        Rule rule2 = new SurviveRuleColorised(List.of(2,3));
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        return rules;
    }
}