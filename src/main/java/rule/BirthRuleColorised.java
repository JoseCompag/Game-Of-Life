package rule;

import cell.*;

import java.util.List;

public class BirthRuleColorised extends Rule{

    private List<Integer> numOfLiveCellsForBirth;
    private List<Cell> cells;

    public BirthRuleColorised(List<Integer> params) {
        this.numOfLiveCellsForBirth = params;
    }

    @Override
    public boolean validate (Cell cell, List<Cell> cells) {
        if (cell.getClass() == RedCell.class || cell.getClass() == GreenCell.class ||
                cell.getClass() == BlueCell.class || cell.getClass() == YellowCell.class) {
            return false;
        }
        this.cells = cells;
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

        for (Cell c : cells) {
            if (c.getClass() == RedCell.class) {
                redCount++;
                if (redCount >= 2) {
                    return new RedCell();
                }
            }
            if (c.getClass() == GreenCell.class) {
                greenCount++;
                if (greenCount >= 2) {
                    return new GreenCell();
                }
            }
            if (c.getClass() == BlueCell.class) {
                blueCount++;
                if (blueCount >= 2) {
                    return new BlueCell();
                }
            }
            if (c.getClass() == YellowCell.class) {
                yellowCount++;
                if (yellowCount >= 2) {
                    return new YellowCell();
                }
            }
        }

        if (redCount == 0){
            return new RedCell();
        }else if (greenCount == 0){
            return new GreenCell();
        }else if (blueCount == 0){
            return new BlueCell();
        }else if (yellowCount == 0){
            return new YellowCell();
        }

        return new DeadCell();
    }

}
