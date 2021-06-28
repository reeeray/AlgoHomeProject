package patterns.behavioral.observer;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2020
 **/
public class ObserverDemo {

    public static void main(String[] args) {
        final Subject subject = new MessageStream();

        final PhoneClient phoneClient = new PhoneClient(subject);
        final TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("Here is a new message!");
        tabletClient.addMessage("Here is another");
    }
}
