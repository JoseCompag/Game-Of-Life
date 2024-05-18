package boards;

import rules.Rule;

import java.util.List;

public abstract class Board {
    public abstract Board newBoard(List<Rule> rules);
}
