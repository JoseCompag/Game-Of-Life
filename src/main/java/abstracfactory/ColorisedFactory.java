package abstracfactory;

import board.Board;
import cell.Cell;
import rule.Rule;

import java.util.List;

public class ColorisedFactory implements AbstracFactory {


    @Override
    public Board createBoardFactory(Integer rows, Integer cols, String configInitial) {
        return null;
    }

    @Override
    public List<Rule> createRuleFactory() {
        return List.of();
    }
}
