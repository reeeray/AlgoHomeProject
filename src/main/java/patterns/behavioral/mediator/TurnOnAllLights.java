package patterns.behavioral.mediator;

/**
 * Concrete command
 * User : Shein G.A.{@reeeray}
 * Date : 01.11.2020
 **/
public class TurnOnAllLights implements Command {

    private Mediator mediator;

    public TurnOnAllLights(final Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        mediator.turnOnAllLight();
    }
}
