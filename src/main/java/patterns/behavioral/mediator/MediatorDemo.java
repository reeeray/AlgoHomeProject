package patterns.behavioral.mediator;

import patterns.behavioral.command.Light;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.11.2020
 **/
public class MediatorDemo {

    public static void main(String[] args) {
        final Mediator mediator = new Mediator();

        final Light kitchen = new Light("Kitchen");
        final Light bedroom = new Light("Bedroom");

        mediator.register(kitchen);
        mediator.register(bedroom);

        final Command turnOnAllLight = new TurnOnAllLights(mediator);
        turnOnAllLight.execute();

        final Command turnOffAllLights = new TurnOffAllLights(mediator);
        turnOffAllLights.execute();

    }
}
