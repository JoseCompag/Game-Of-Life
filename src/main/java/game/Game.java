package game;

import abstracfactory.*;
import board.Board;
import board.RectangularBoard;
import cell.CellFactory;
import gamecontroller.*;
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
        CellFactory cellFactory = factory.getCellFactory();
        Board board = new RectangularBoard(config.rows, config.cols, config.initialConfig, cellFactory);
        List<Rule> rules = factory.createRules();
        board.setRules(rules);

        GameController gameController = new StartDefault(board);
        TerminalOutput output = new TerminalOutput(gameController);
        gameController.start();
    }

    private AbstracFactory createFactory(String gamemode) {
      switch (gamemode) {
        case "traditional":
          return new TraditionalFactory();
        case "traditionalHL":
          return new TraditionalHLFactory();
        case "colorisedQL":
          return new ColorisedQLFactory();
        case "colorisedIm":
          return new ColorisedImFactory();
        case "generationsBB":
          return  new GenerationsBBFactory();
        case "generationsSW":
          return  new GenerationsSWFactory();
      }
      return null;
    }

}
