package rule.ColourisedImGame;

import cell.*;
import cell.ColourisedImGame.DeadCell;
import rule.Rule;

import java.util.List;

public class SurviveRule extends Rule {

    private List<Integer> numOfLiveCellsForSurvive;
    private Cell res;

    public SurviveRule(List<Integer> params) {
        this.numOfLiveCellsForSurvive = params;
    }

    @Override
    public boolean validate (Cell cell, List<Cell> cells) {
        if(cell.getClass() == DeadCell.class){
            return false;
        }
        this.res = cell;
        int count = 0;
        for (Cell c : cells) {
            if (c.getClass() != DeadCell.class) {
                count++;
            }
        }
        for (Integer integer : numOfLiveCellsForSurvive) {
            if (count == integer) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Cell apply() {
        return this.res;
    }

}
