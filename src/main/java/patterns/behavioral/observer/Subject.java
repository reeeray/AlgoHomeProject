package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject according to observer design pattern
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2020
 **/
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    abstract void setState(final String state);

    abstract String getState();

    public void attach(final Observer observer) {
        observers.add(observer);
    }

    public void detach(final Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.update());
    }
}
