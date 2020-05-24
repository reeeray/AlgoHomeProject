package patterns.creational.builder;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class LunchOrderDemo {

    public static final String WHEAT = "Wheat";
    public static final String LETTUCE = "Lettuce";
    public static final String MAYO = "Mayo";
    public static final String HAMON = "Hamon";

    public static void main(String[] args) {
        LunchOrder.Builder lunch = new LunchOrder.Builder();
        lunch.bread(WHEAT).condiments(LETTUCE).dressing(MAYO).meat(HAMON);

        LunchOrder order = lunch.build();

        assert order.getBread().equals(WHEAT);
        assert order.getCondiments().equals(LETTUCE);
        assert order.getDressing().equals(MAYO);
        assert order.getMeat().equals(HAMON);
    }
}
