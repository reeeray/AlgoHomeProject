package patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker according to the Command Pattern UML diagram
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2020
 **/
public class CommandDemo {

    public static void main(String[] args) {
        final Light light = new Light(); //receiver
        final Switch lightSwithch = new Switch();//Invoker

        final Command onCommand = new OnCommand(light);

        lightSwithch.storeAndExecute(onCommand);

        //now it keeps state
        final Command toggleCommand = new ToggleCommand(light);

        lightSwithch.storeAndExecute(toggleCommand);
        lightSwithch.storeAndExecute(toggleCommand);
        lightSwithch.storeAndExecute(toggleCommand);

        //Macros on it
        final Light bedroomLight = new Light();
        final Light kitchenLight = new Light();
        final List<Light> lights = new ArrayList<>();
        lights.add(bedroomLight);
        lights.add(kitchenLight);

        final Command allLightsCommand = new AllLightsCommand(lights);

        lightSwithch.storeAndExecute(allLightsCommand);

    }
}
