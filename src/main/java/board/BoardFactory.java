package board;

import rule.Rule;

import java.util.ArrayList;

public class BoardFactory {

    public Board createBoard (String type, ArrayList<Integer> paramsSize, String initialConfig, ArrayList<Rule> rules) {
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
