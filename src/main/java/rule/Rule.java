package rule;

import cell.Cell;

import java.util.HashMap;
import java.util.List;

public abstract class Rule {

  public abstract boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors);
  public abstract Cell apply(Cell cell, HashMap<Class<?>, Integer> neighbors);

}