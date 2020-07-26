package patterns.structural.proxy;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.07.2020
 **/
public class TwitterServiceStub implements TwitterService {
    @Override
    public String getTimeLine(String screenName) {
        return "My neato timeline";
    }

    @Override
    public void postToTimeLine(String screenName, String message) {

    }
}
