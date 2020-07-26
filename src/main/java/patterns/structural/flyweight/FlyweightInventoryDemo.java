package patterns.structural.flyweight;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2020
 **/
public class FlyweightInventoryDemo {

    public static void main(String[] args) {
        final InventorySystem inventory = new InventorySystem();

        inventory.takeOrder("AirPods", 333);
        inventory.takeOrder("MacBook", 777);
        inventory.takeOrder("IPhone", 555);
        inventory.takeOrder("AirPods", 33);
        inventory.takeOrder("MacBook", 77);
        inventory.takeOrder("IPhone", 55);
        inventory.takeOrder("AirPods", 3);
        inventory.takeOrder("MacBook", 7);
        inventory.takeOrder("IPhone", 5);

        inventory.process();

        System.out.println(inventory.report());
    }
}
