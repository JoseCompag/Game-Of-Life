package system;

import abstracfactory.AbstracFactory;
import board.Board;
import board.BoardFactory;
import game.GameController;
import output.TerminalOutput;
import rule.*;

import java.util.ArrayList;

public class Game {

    private String nameConfigProperties;
    private int generations;

    public Game(String nameConfigProperties, int generations) {
        this.nameConfigProperties = nameConfigProperties;
        this.generations = generations;
    }

    public void start() {
        Config config = new Config(nameConfigProperties);
        config.loadConfig();
        String gamemode = config.gamemode;
        GameController gameController = new GameController();
        AbstracFactory factory;


        /*
        String gamemode = config
        AbstracFactory factory;
        //gamemode
        if (str = traditional)
            factory = new TraditionalFactory();
        if (str = highlife)
            factory =  new HighlifeFactory();


        GameController game = new GameController(factory.createBoardFactory());


        factory
                factory rules
                factory board


        af

        CellFactory cf = factory.createCellFactory(); ESTO VA EN LA CREACIÓN DE TABLERO
        Rules rules = factory.createRules();
        Board board = factory.createBoard(rules);

        <List> rules = factory.create(str);
        */


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

        GameController game = new GameController(board);
        TerminalOutput output = new TerminalOutput(game);
        game.start(generations);
    }

}
