package system;

import board.Board;
import board.BoardFactory;
import game.Game;
import output.TerminalOutput;
import rule.*;

import java.util.ArrayList;

public class System {

    private String nameConfigProperties;
    private int generations;

    public System (String nameConfigProperties, int generations) {
        this.nameConfigProperties = nameConfigProperties;
        this.generations = generations;
    }

    public void start() {
        Config config = new Config(nameConfigProperties);
        config.loadConfig();

        ArrayList<Rule> rules = new ArrayList<>();
        RuleFactory ruleFactory = new RuleFactory();
        Rule birthRule = ruleFactory.createRule("birth", config.numOfLiveCellsToBirth);
        Rule surviveRule = ruleFactory.createRule("survive", config.numOfLiveCellsToSurvive);
        Rule deathRule = ruleFactory.createRule("death", new ArrayList<>());
        rules.add(0,birthRule);
        rules.add(1,surviveRule);
        rules.add(2,deathRule);

        ArrayList<Integer> paramsSize = new ArrayList<>();
        paramsSize.add(0, config.rows);
        paramsSize.add(1, config.cols);
        BoardFactory boardFactory = new BoardFactory();
        Board board = boardFactory.createBoard(config.typeBoard, paramsSize, config.initialConfig, rules);

        Game game = new Game(board);
        TerminalOutput output = new TerminalOutput(game);
        game.start(generations);
    }

}
