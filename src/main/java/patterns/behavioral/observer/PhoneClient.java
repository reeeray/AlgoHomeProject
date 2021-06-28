package patterns.behavioral.observer;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2020
 **/
public class PhoneClient extends Observer {

    public PhoneClient(final Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void addMessage(final String message) {
        this.subject.setState(message + " - sent from phone.");
    }

    @Override
    void update() {
        System.out.println("Phone Stream : " + subject.getState());
    }
}
