package abstracfactory;

import board.Board;
import rule.Rule;

import java.util.List;

public interface AbstracFactory {


    Board createBoardFactory(Integer rows, Integer cols, String configInitial);
    List<Rule> createRuleFactory();
}
