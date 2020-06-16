package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public abstract class MenuComponent {

    String name;
    String url;
    List<MenuComponent> menuComponents = new ArrayList<>();


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public abstract String toString();

    String print(final MenuComponent menuComponent) {
        final StringBuilder sb = new StringBuilder(menuComponent.name);
        sb.append(": ");
        sb.append(menuComponent.url);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
