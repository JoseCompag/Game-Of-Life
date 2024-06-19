package output;


import board.Board;
import gamecontroller.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOutput implements Output {

  private GameController gameController;
  private String path = "files";

  public FileOutput(GameController game) {
    this.gameController = game;
    game.registerObserver(this);
  }

  public void update(Board board, Integer generation) {
    try {
      Path directoryPath = Paths.get(path);
      if (!Files.exists(directoryPath)) {
        Files.createDirectories(directoryPath);
      }

      FileWriter fw = new FileWriter(new File(directoryPath.toFile(), "generation" + generation + ".txt"));
      fw.write(board.toString());
      fw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
