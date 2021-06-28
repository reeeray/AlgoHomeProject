package patterns.behavioral.observer;

/**
 * Observer
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2020
 **/
public class TabletClient extends Observer {

    public TabletClient(final Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void addMessage(final String message) {
        this.subject.setState(message + " - sent from tablet.");
    }

    @Override
    void update() {
        System.out.println("Tablet stream : " + this.subject.getState());
    }
}
