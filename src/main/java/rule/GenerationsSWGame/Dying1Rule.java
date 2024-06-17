package rule.GenerationsSWGame;

import cell.Cell;
import cell.GenerationsSWGame.DyingCell1;
import cell.GenerationsSWGame.LivingCell;
import rule.Rule;

import java.util.HashMap;

public class Dying1Rule extends Rule {

    public Dying1Rule() {}

    @Override
    public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
        if (cell.getClass() != LivingCell.class) {
            return false;
        }
        return true;
    }

    @Override
    public Cell apply (Cell cell, HashMap<Class<?>, Integer> neighbors) {
        return new DyingCell1();
    }

}
