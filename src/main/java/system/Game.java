package system;

import abstracfactory.AbstracFactory;
import abstracfactory.ColorisedFactory;
import abstracfactory.HightLifeFactory;
import abstracfactory.TraditionalFactory;
import board.Board;
import game.GameController;
import output.TerminalOutput;
import rule.*;

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

        AbstracFactory factory = createFactory(config.gamemode);
        Board board = factory.createBoard(config.rows, config.cols, config.initialConfig);
        List<Rule> rules = factory.createRule();
        board.setRules(rules);

        GameController gameController = new GameController(board);
        TerminalOutput output = new TerminalOutput(gameController);
        gameController.start(generations);
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
      return null;
    }

}
