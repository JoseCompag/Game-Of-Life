package board;

import rule.Rule;

import java.util.List;

public abstract class Board {

    List<Rule> rules;

    public void setRules(List<Rule> rules){
        this.rules = rules;
    }
    public abstract Board nextBoard();

}
