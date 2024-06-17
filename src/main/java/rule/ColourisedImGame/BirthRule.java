package rule.ColourisedImGame;

import cell.*;
import cell.ColourisedImGame.BlueCell;
import cell.ColourisedImGame.RedCell;
import cell.TraditionalGame.DeadCell;
import rule.Rule;

import java.util.List;

public class BirthRule extends Rule {

    private List<Integer> numOfLiveCellsForBirth;
    private List<Cell> neighborsCells;

    public BirthRule(List<Integer> params) {
        this.numOfLiveCellsForBirth = params;
    }

    @Override
    public boolean validate (Cell cell, List<Cell> cells) {
        if (cell.getClass() != DeadCell.class) {
            return false;
        }
        this.neighborsCells = cells;
        int count = 0;
        for (Cell c : cells) {
            if (c.getClass() != DeadCell.class) {
                count++;
            }
        }
        for (Integer integer : numOfLiveCellsForBirth) {
            if (count == integer) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Cell apply() {
        int redCount = 0;
        int greenCount = 0;
        int blueCount = 0;
        int yellowCount = 0;

        for (Cell c : neighborsCells) {
            if (c.getClass() == RedCell.class) {
                redCount++;
                if (redCount >= 2) {
                    return new RedCell();
                }
            }
            if (c.getClass() == BlueCell.class) {
                blueCount++;
                if (blueCount >= 2) {
                    return new BlueCell();
                }
            }
        }

        if (redCount == 0){
            return new RedCell();
        }else if (blueCount == 0){
            return new BlueCell();
        }

        return new DeadCell();
    }

}