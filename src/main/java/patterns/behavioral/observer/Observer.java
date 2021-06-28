package patterns.behavioral.observer;

/**
 * Observer
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2020
 **/
public abstract class Observer {
    protected Subject subject;

    abstract void update();
}
