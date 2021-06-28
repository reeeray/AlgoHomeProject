package patterns.behavioral.command;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2020
 **/
public class AllLightsCommand implements Command {

    private List<Light> lights;

    public AllLightsCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        for (final Light light : lights)
            light.toggle();
    }
}
