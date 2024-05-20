package board;

import rule.Rule;

import java.util.List;

public abstract class Board {

    public abstract Board nextBoard (List<Rule> rules);

}
