package patterns.creational.factory;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
@Getter
public abstract class Website {

    protected List<Page> pages = new ArrayList<>();

    public Website() {
        this.createWebsite();
    }

    public abstract void createWebsite();
}
