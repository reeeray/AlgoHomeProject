package patterns.behavioral.command;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2020
 **/
public class ToggleCommand implements Command {

    private Light light;

    public ToggleCommand(final Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.toggle();
    }
}
