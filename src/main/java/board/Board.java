package board;

import rule.Rule;

import java.util.List;

public abstract class Board {

    List<Rule> rules;

    public abstract Board nextBoard();


}
