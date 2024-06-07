package abstracfactory;

import board.Board;
import rule.Rule;

import java.util.List;

public interface AbstracFactory {

    Board createBoard(Integer rows, Integer cols, String configInitial);
    List<Rule> createRule();

}
