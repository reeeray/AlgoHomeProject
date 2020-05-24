package patterns.creational.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
@Getter
@Setter
public abstract class Item implements Cloneable {

    private String title;
    private double price;
    private String url;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
