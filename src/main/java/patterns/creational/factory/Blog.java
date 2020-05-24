package patterns.creational.factory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class Blog extends Website {
    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}
