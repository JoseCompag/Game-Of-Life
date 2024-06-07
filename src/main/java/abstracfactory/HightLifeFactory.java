package abstracfactory;

import board.Board;
import cell.Cell;
import rule.Rule;

import java.util.List;

public class HightLifeFactory implements AbstracFactory {

    @Override
    public Cell createCell() {
        return null;
    }

    @Override
    public Board createBoard() {
        return null;
    }

    @Override
    public List<Rule> createRules() {
        return List.of();
    }
}
