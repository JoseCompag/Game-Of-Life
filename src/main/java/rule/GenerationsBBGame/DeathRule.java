package rule.GenerationsBBGame;

import cell.Cell;
import cell.GenerationsBBGame.DeadCell;
import rule.Rule;

import java.util.List;

public class DeathRule extends Rule {

  public DeathRule() {}

  @Override
  public boolean validate (Cell cell, List<Cell> cells) {
    return true;
  }

  @Override
  public Cell apply() {
    return new DeadCell();
  }

}