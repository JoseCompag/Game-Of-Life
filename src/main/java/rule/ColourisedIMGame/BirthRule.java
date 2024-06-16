package rule.ColourisedIMGame;

import cell.*;
import cell.ColourisedImGame.BlueCell;
import cell.ColourisedImGame.RedCell;
import cell.ColourisedImGame.DeadCell;
import rule.Rule;

import java.util.List;

public class BirthRule extends Rule {

    public BirthRule() {}

    @Override
    public Cell apply(Cell cell) {
        List<Cell> neighbors = this.cells.get(cell);

        if (cell.getClass() != DeadCell.class || neighbors.size() != 3) {
            return cell;
        }

        int redCount = 0;
        int blueCount = 0;

        for (Cell c : neighbors) {
            if (c.getClass() == RedCell.class) {
                redCount++;
            }
            if (c.getClass() == BlueCell.class) {
                blueCount++;
            }
        }


        if (redCount == 2) {
            return new RedCell();
        }
        if (blueCount == 2) {
            return new BlueCell();
        }

        return cell;
    }

}
