package abstracfactory;

import board.Board;
import board.BoardFactory;
import cell.CellFactory;
import rule.Rule;
import rule.RuleFactory;

import java.util.List;

public interface AbstracFactory {

    Board createBoardFactory(Integer rows, Integer cols, String configInitial);
    List<Rule> createRuleFactory();
}
