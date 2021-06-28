package patterns.behavioral.mediator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.11.2020
 **/
public class TurnOffAllLights implements Command {

    private Mediator mediator;

    public TurnOffAllLights(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        mediator.turnOffAllLights();
    }
}
