package patterns.behavioral.command;

/**
 * Concrete Command according to the Command Pattern UML diagram
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2020
 **/
public class OnCommand implements Command {

    private Light light;

    public OnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
    }
}
