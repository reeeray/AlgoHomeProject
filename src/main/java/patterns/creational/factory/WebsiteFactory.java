package patterns.creational.factory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class WebsiteFactory {

    public static Website getWebsite(final WebsiteType siteType) {
        switch (siteType) {
            case BLOG:
                return new Blog();
            case SHOP:
                return new Shop();
                default :
                    return null;


        }
    }
}
