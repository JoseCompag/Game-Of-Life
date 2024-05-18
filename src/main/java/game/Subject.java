package game;


import output.Observer;

import java.util.List;

public abstract class Subject {
  List<Observer> observers;

  public void registerObserver(Observer o){
    observers.add(o);
  }
  public void removeObserver(Observer o){
    observers.remove(o);
  }
  public abstract void notifyObservers();
}
