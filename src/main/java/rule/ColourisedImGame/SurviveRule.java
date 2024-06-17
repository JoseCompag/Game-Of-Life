package rule.ColourisedImGame;

import cell.*;
import cell.ColourisedImGame.BlueCell;
import cell.ColourisedImGame.DeadCell;
import cell.ColourisedImGame.RedCell;
import rule.Rule;

import java.util.HashMap;

public class SurviveRule extends Rule {

    public SurviveRule() {}

    @Override
    public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
        if(cell.getClass() == DeadCell.class){
            return false;
        }

        Integer numOfRed = neighbors.get(RedCell.class);
        Integer numOfBlue = neighbors.get(BlueCell.class);
        if (numOfBlue == null) {
            numOfBlue = 0;
        }
        if (numOfRed == null) {
            numOfRed = 0;
        }
        return numOfRed + numOfBlue == 3 || numOfRed + numOfBlue == 2;
    }

    @Override
    public Cell apply(Cell cell, HashMap<Class<?>, Integer> neighbors) {
        return cell;
    }

}