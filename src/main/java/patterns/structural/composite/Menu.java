package patterns.structural.composite;

import java.util.Iterator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public class Menu extends MenuComponent {

    public Menu(final String name, final String url) {
        this.name = name;
        this.url = url;
    }

    //@Override
    public MenuComponent add(final MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
        return menuComponent;
    }

    //@Override
    public MenuComponent remove(final MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
        return menuComponent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(print(this));
        Iterator<MenuComponent> componentsIterator = menuComponents.iterator();
        while (componentsIterator.hasNext()) {
            sb.append(componentsIterator.next());
        }
        return sb.toString();
    }
}
