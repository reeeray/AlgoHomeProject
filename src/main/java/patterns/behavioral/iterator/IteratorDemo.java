package patterns.behavioral.iterator;

import java.util.Iterator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.10.2020
 **/
public class IteratorDemo {

    public static void main(String[] args) {
        final BikeRepository bikes = new BikeRepository();

        bikes.add("Suzuki");
        bikes.add("BMW");
        bikes.add("Ducatti");

        final Iterator iterator = bikes.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
