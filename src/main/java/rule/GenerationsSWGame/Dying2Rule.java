package rule.GenerationsSWGame;

import cell.Cell;
import cell.GenerationsSWGame.DyingCell1;
import cell.GenerationsSWGame.DyingCell2;
import rule.Rule;

import java.util.HashMap;

public class Dying2Rule extends Rule {

    public Dying2Rule() {}

    @Override
    public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
        if (cell.getClass() != DyingCell1.class) {
            return false;
        }
        return true;
    }

    @Override
    public Cell apply (Cell cell, HashMap<Class<?>, Integer> neighbors) {
        return new DyingCell2();
    }

}
