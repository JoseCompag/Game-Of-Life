package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;
import java.util.Scanner;

public class Manual extends GameController {

  public Manual(Board board) {
    this.board = board;
    observers = new ArrayList<Observer>();
  }

  @Override
  public void start() {

    generation = 0;
    System.out.print("\033[H\033[2J");
    System.out.flush();
    String print = board.toString();
    System.out.println("---"+generation+"---");
    System.out.println(print);
    generation++;

    Scanner scanner = new Scanner(System.in);
    boolean bool = true;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
      String input = scanner.nextLine();
      if (!input.isEmpty()) {
        bool = false;
      }
    } while (bool);
  }

}
