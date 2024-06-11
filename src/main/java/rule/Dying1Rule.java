package rule;

import cell.*;

import java.util.List;

public class Dying1Rule extends Rule {

    public Dying1Rule() {}

    @Override
    public boolean validate (Cell cell, List<Cell> cells) {
        return true;
    }

    @Override
    public Cell apply() {
        return new DyingCell1();
    }

}
