package patterns.behavioral.iterator;

import java.util.Iterator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.10.2020
 **/
public class BikeRepository implements Iterable<String> {

    private String[] bikes;
    private int index;

    public BikeRepository() {
        bikes = new String[10];
        index = 0;
    }

    public void add(final String bike) {
        if (index == bikes.length) {
            final String[] largerBikes = new String[bikes.length * 2];
            System.arraycopy(bikes, 0, largerBikes, 0, bikes.length);
            bikes = largerBikes;
        }
        bikes[index++] = bike;
    }

    @Override
    public Iterator iterator() {
        final Iterator<String> it = new Iterator<String>() {

            private int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < bikes.length && bikes[currentIndex] != null;
            }

            @Override
            public String next() {
                return bikes[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        return it;
    }
}
