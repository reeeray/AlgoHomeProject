package patterns.structural.composite;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public class MenuItem extends MenuComponent {

    public MenuItem(final String name, final String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return print(this);
    }
}
