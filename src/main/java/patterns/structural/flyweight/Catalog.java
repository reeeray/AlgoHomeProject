package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Catalog acts as a factory and cache for Item flyweight objects
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2020
 **/
public class Catalog {

    private final Map<String, Item> items = new HashMap<>();

    //factory method
    public Item lookup(final String itemName) {
        if (!items.containsKey(itemName))
            items.put(itemName, new Item(itemName));
        return items.get(itemName);
    }

    public int totalItemsMade() {
        return items.size();
    }
}
