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

    public Game(String nameConfigProperties) {
        this.nameConfigProperties = nameConfigProperties;
    }

    public void start() {
        Config config = new Config(nameConfigProperties);
        config.loadConfig();

        AbstracFactory factory = createFactory(config.gamemode);
        CellFactory cellFactory = factory.getCellFactory();
        Board board = new RectangularBoard(config.rows, config.cols, config.initialConfig, cellFactory);
        List<Rule> rules = factory.createRules();
        board.setRules(rules);

        GameController gameController = createController(board, config.advanceMode);
        TerminalOutput output = new TerminalOutput(gameController);
        gameController.start();
    }

    private AbstracFactory createFactory(String gamemode) {
      switch (gamemode) {
        case "traditional":
          return new TraditionalFactory();
        case "traditionalHL":
          return new TraditionalHLFactory();
        case "colorisedIm":
          return new ColorisedImFactory();
        case "colorisedQL":
          return new ColorisedQLFactory();
        case "generationsBB":
          return  new GenerationsBBFactory();
        case "generationsSW":
          return  new GenerationsSWFactory();
      }
      return null;
    }

    private GameController createController (Board board, String advanceMode) {
        switch (advanceMode) {
            case "slow":
                return new Speed(board, 500);
            case "fast":
                return new Speed(board, 50);
            case "manual":
                return new Manual(board);
        }
        return new Delimited(board, Integer.parseInt(advanceMode));
    }

}
