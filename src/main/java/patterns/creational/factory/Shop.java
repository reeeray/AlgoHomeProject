package patterns.creational.factory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class Shop extends Website {
    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
