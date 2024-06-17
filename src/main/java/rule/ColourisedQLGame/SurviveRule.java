package rule.ColourisedQLGame;

import cell.Cell;
import cell.ColourisedQLGame.BlueCell;
import cell.ColourisedQLGame.GreenCell;
import cell.ColourisedQLGame.RedCell;
import cell.ColourisedQLGame.YellowCell;
import cell.DeadCell;
import rule.Rule;

import java.util.HashMap;
import java.util.List;

public class SurviveRule extends Rule {

    public SurviveRule() { }

    @Override
    public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {

      if(cell.getClass() == DeadCell.class){
            return false;
      }

      Integer numOfRed = neighbors.get(RedCell.class);
      Integer numOfBlue = neighbors.get(BlueCell.class);
      Integer numOfGreen = neighbors.get(GreenCell.class);
      Integer numOfYellow = neighbors.get(YellowCell.class);

      if (numOfBlue == null) {
        numOfBlue = 0;
      }
      if (numOfRed == null) {
        numOfRed = 0;
      }
      if (numOfGreen == null) {
        numOfGreen = 0;
      }
      if (numOfYellow == null) {
        numOfYellow = 0;
      }

      int res = numOfRed + numOfBlue + numOfGreen + numOfYellow;

      return res == 3 || res == 2;

    }

    @Override
    public Cell apply(Cell cell, HashMap<Class<?>, Integer> neighbors) {
        return cell;
    }

}