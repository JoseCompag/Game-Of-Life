package rule.ColourisedImGame;

import cell.*;
import cell.ColourisedImGame.BlueCell;
import cell.ColourisedImGame.RedCell;
import cell.DeadCell;
import rule.Rule;

import java.util.HashMap;

public class BirthRule extends Rule {

    public BirthRule() {}

    @Override
    public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
        if (cell.getClass() != DeadCell.class) {
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
        return numOfRed + numOfBlue == 3;
    }

    @Override
    public Cell apply (Cell cell, HashMap<Class<?>, Integer> neighbors) {

        Integer numOfRed = neighbors.get(RedCell.class);
        Integer numOfBlue = neighbors.get(BlueCell.class);
        if (numOfBlue == null) {
            numOfBlue = 0;
        }
        if (numOfRed == null) {
            numOfRed = 0;
        }

        if (numOfRed >= 2) {
            return new RedCell();
        }
        if (numOfBlue >= 2) {
            return new BlueCell();
        }
        return new DeadCell();




    }

}
