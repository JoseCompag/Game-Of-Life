package output;


import board.Board;
import gamecontroller.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Observer {

  private GameController gameController;
  private String path = "../tp2-GameOfLife/files";

  public FileOutput(GameController game) {
    this.gameController = game;
    game.registerObserver(this);
  }

  @Override
  public void update(Board board, Integer generation) {
    try {
      FileWriter fw = new FileWriter(new File(path,"generation"+generation+".txt"));
      fw.write(board.toString());
      fw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
