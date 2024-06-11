package rule;

import cell.Cell;
import cell.DyingCell2;

import java.util.List;

public class Dying2Rule extends Rule {

    public Dying2Rule() {}

    @Override
    public boolean validate (Cell cell, List<Cell> cells) {
        return true;
    }

    @Override
    public Cell apply() {
        return new DyingCell2();
    }

}
