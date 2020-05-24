package patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Pattern
 *
 * Best way to set some default information and than we can override it without call "new" each time.
 * It's a lot lighter way object instantiation and fastest way to get uniqe object each time when we ask for this object back.
 * User : gshein
 * Date : 23.05.2020
 **/
public class Registry {

    private Map<String, Item> items = new HashMap<>();

    public Registry() {
        loadItems();
    }

    public Item createItem (String type) {
        Item item = null;

        try {
            item = (Item)(items.get(type)).clone();
        }catch (final CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return item;
    }

    private void loadItems() {
        final Movie movie = new Movie();
        movie.setTitle("Filth");
        movie.setPrice(24.99D);
        movie.setRuntime("2hours10minutes");
        items.put("Movie", movie);

        final Book book = new Book();
        book.setNumberOfPages(399);
        book.setPrice(19.99);
        book.setTitle("Solaris");
        items.put("Book", book);
    }
}
