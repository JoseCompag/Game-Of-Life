package boards;

import rules.Rule;

import java.util.List;

public abstract class Board {


    public abstract Board nextBoard(List<Rule> rules);
    public abstract void setNeighbors();
}
