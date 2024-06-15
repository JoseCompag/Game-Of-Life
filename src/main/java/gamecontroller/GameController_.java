/*package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController__ extends Subject {

  private Board board;
  private Integer generation;
  private Integer generationMax = 60;

  public GameController_(Board board) {
    this.board = board;
    observers = new ArrayList<Observer>();
  }

  public void setBoard (Board board) {
    this.board = board;
  }

  public Board getBoard() {
    return board;
  }

  public void start (Integer generationMax) {
    this.generationMax = generationMax;
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
    } while (generation < generationMax);
  }

  public void start () {
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
    } while (generation < generationMax);
  }

  public void startOneStep () {
    generation = 0;
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



  public void startTime () {
    int time = 600;
    Scanner scanner = new Scanner(System.in);
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
      if (generation % 15 == 0){
        System.out.println("time: " +time);
        String input = scanner.nextLine();
        if (input.equals("+")) {
          time = (int) (time / 1.3);
        }else if (input.equals("-")) {
          time = (int) (time * 1.3);
        }
      }
      try {
        Thread.sleep(time);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    } while (generation < generationMax);
  }



  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update (board, generation);
    }
  }

}
*/