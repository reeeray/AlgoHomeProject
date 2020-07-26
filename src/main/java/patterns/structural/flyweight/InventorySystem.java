package patterns.structural.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2020
 **/
public class InventorySystem {

    private final Catalog catalog = new Catalog();
    private final List<Order> orders = new CopyOnWriteArrayList<Order>();

    void takeOrder(final String itemName, final int orderNumber) {
        final Item item = catalog.lookup(itemName);
        final Order order = new Order(orderNumber, item);
        orders.add(order);
    }

    void process() {
        for (final Order order : orders) {
            order.processOrder();
            orders.remove(order);
        }
    }

    String report() {
        return "/nTotal item objects made:"
                + catalog.totalItemsMade();
    }
}
