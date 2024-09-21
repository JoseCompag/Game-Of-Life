package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManualQN extends GameController{

  public ManualQN(Board board) {
    this.board = board;
    observers = new ArrayList<Observer>();
  }

  @Override
  public void start() {

    generation = 0;
    notifyObservers();
    Scanner scanner = new Scanner(System.in);

    do {
      String input = scanner.nextLine();
      if (input.equals("q")) {
        break;
      }else if (input.equals("n")) {
        this.board = board.nextBoard();
        generation++;
        notifyObservers();
      }
    } while (true);
  }

}
