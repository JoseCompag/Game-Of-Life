package system;

import abstracfactory.AbstracFactory;
import abstracfactory.ColorisedFactory;
import abstracfactory.HightLifeFactory;
import abstracfactory.TraditionalFactory;
import board.Board;
import game.GameController;
import output.TerminalOutput;
import rule.*;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String nameConfigProperties;
    private Integer generations = 10;

    public Game(String nameConfigProperties, int generations) {
        this.nameConfigProperties = nameConfigProperties;
        this.generations = generations;
    }

    public void start() {
        Config config = new Config(nameConfigProperties);
        config.loadConfig();
        String gamemode = config.gamemode;
        AbstracFactory factory = createFactory(gamemode);
        Board board = factory.createBoardFactory(config.rows, config.cols, config.initialConfig);
        List<Rule> rules = factory.createRuleFactory();
        board.setRules(rules);

        GameController gameController = new GameController(board);
        TerminalOutput output = new TerminalOutput(gameController);

        gameController.start(generations);

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



        GameController game = new GameController(board);
        TerminalOutput output = new TerminalOutput(game);
        game.start(generations)
        */
    }

    private AbstracFactory createFactory(String gamemode) {
      switch (gamemode) {
        case "traditional":
          return new TraditionalFactory();
        case "hightlife":
          return new HightLifeFactory();
        case "colorised":
          return new ColorisedFactory();
      }

      return null; // CAMBIAR ESTO
    }

}
