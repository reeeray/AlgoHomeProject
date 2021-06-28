package patterns.behavioral.observer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2020
 **/
public class MessageStream extends Subject {

    private Deque<String> messageHistory = new ArrayDeque<>();

    @Override
    void setState(String message) {
        messageHistory.add(message);
        notifyObservers();
    }

    @Override
    String getState() {
        return messageHistory.getLast();
    }
}
