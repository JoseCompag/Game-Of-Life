package rule.ColourisedIMGame;

import cell.*;
import cell.ColourisedImGame.DeadCell;
import rule.Rule;

import java.util.List;

public class SurviveRule extends Rule {

    public SurviveRule() {
    }

    @Override
    public Cell apply(Cell cell) {

        List<Cell> neighbors = this.cells.get(cell);

        if(cell.getClass() != DeadCell.class ){
            if(neighbors.size() == 2 || neighbors.size() == 3){
                return cell;
            }
        }

        return new DeadCell();
    }

}
