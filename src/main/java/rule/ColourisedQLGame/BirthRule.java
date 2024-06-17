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

public class BirthRule extends Rule {

    public BirthRule() {

    }

    @Override
    public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
        if (cell.getClass() != DeadCell.class) {
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
      return numOfRed + numOfBlue + numOfGreen + numOfYellow == 3;

    }

    @Override
    public Cell apply(Cell cell, HashMap<Class<?>, Integer> neighbors) {

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

      if (numOfRed >= 2) {
        return new RedCell();
      }else if (numOfGreen >= 2) {
        return new GreenCell();
      }else if (numOfYellow >= 2) {
        return new YellowCell();
      }else if (numOfBlue >= 2) {
        return new BlueCell();
      } else if (numOfRed == 0){
        return new RedCell();
      }else if (numOfGreen == 0){
        return new GreenCell();
      }else if (numOfBlue == 0){
        return new BlueCell();
      }else if (numOfYellow == 0){
        return new YellowCell();
      }

      return cell;
    }

}
