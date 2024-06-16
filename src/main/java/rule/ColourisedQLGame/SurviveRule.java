package rule.ColourisedQLGame;

import cell.Cell;
import cell.ColourisedQLGame.DeadCell;
import rule.Rule;

import java.util.List;

public class SurviveRule extends Rule {

    private List<Integer> numOfLiveCellsForSurvive;

    public SurviveRule(List<Integer> params) {
        this.numOfLiveCellsForSurvive = params;
    }


    @Override
    public Cell apply(Cell cell) {

        List<Cell> neighbors = this.cells.get(cell);

        if(cell.getClass() != DeadCell.class ){
          for(Integer integer : numOfLiveCellsForSurvive){
            if (neighbors.size() == integer) {
                return cell;
            }
          }
        }
        return new DeadCell();

    }

}
