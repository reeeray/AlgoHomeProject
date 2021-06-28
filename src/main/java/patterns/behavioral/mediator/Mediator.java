package patterns.behavioral.mediator;

import patterns.behavioral.command.Light;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.11.2020
 **/
public class Mediator {

    private List<Light> lights = new ArrayList<>();

    public void register(final Light light) {
        lights.add(light);
    }

    public void turnOnAllLight() {
        lights.stream().filter(light -> !light.isOn()).forEach(Light::toggle);
    }

    public void turnOffAllLights() {
        lights.stream().filter(Light::isOn).forEach(Light::toggle);
    }
}
