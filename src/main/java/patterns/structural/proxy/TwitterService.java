package patterns.structural.proxy;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.07.2020
 **/
public interface TwitterService {
    public String getTimeLine(final String screenName);

    public void postToTimeLine(final String screenName, final String message);
}
