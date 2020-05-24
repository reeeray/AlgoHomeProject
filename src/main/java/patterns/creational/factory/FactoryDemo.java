package patterns.creational.factory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class FactoryDemo {

    public static void main(String[] args) {
        Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println(site.getPages());

    }
}
