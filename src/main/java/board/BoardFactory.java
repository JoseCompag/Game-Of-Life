package board;

import rule.Rule;

import java.util.List;

public class BoardFactory {

    public Board createBoard (String type, List<Integer> paramsSize, String initialConfig, List<Rule> rules) {
        if (type.equals("rectangular")) {
            int rows = paramsSize.get(0);
            int cols = paramsSize.get(1);
            Board board = new RectangularBoard(rows, cols, initialConfig, rules);
            return board;
        } else {
            return null;
        }
    }

}
