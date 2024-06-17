package rule.GenerationsBBGame;

import cell.Cell;
import cell.GenerationsBBGame.DyingCell1;
import cell.GenerationsBBGame.LivingCell;
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
