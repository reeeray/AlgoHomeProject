package patterns.structural.flyweight;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2020
 **/
public class Order {
    private final int orderNumber;
    private final Item item;

    public Order(final int orderNumber, final Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    public void processOrder() {
        System.out.println("Ordering " + item + " with order number " + orderNumber);
    }
}
