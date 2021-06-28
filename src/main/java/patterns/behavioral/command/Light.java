package patterns.behavioral.command;

import lombok.Getter;

/**
 * Receiver according to the Command Pattern UML diagram
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2020
 **/
public class Light {

    @Getter
    private boolean isOn = false;

    @Getter
    private String location = "";

    public Light() {
    }

    public Light(final String location) {
        this.location = location;
    }

    public void toggle() {
        if (isOn) {
            this.off();
            this.isOn = false;
        } else {
            this.on();
            this.isOn = true;
        }
    }

    public void on() {
        System.out.println(location + " Light switched on.");
    }

    public void off() {
        System.out.println(location + " Light switched off.");
    }
}
