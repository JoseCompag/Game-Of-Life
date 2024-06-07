package abstracfactory;

import board.Board;
import rule.Rule;

import java.util.List;

public class ColorisedFactory implements AbstracFactory {

    public ColorisedFactory(){}

    @Override
    public Board createBoard(Integer rows, Integer cols, String configInitial) {
        return null;
    }

    @Override
    public List<Rule> createRule() {
        return List.of();
    }
}
