package board;

import cell.Cell;
import rule.Rule;

import java.util.List;

public abstract class Board {

    List<Rule> rules;

    public abstract Board nextBoard();
    public void setRules(List<Rule> rules){
        this.rules = rules;
    }
}
