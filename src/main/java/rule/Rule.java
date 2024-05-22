package rule;

import cell.Cell;

import java.util.List;

public abstract class Rule {

  public abstract boolean validate (Cell cell, List<Cell> cells);

  public abstract Cell apply();

}
