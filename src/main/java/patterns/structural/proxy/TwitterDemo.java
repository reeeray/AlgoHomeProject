package patterns.structural.proxy;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.07.2020
 **/
public class TwitterDemo {

    public static void main(String[] args) {
        final TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());
        final TwitterService realService = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());

        System.out.println(service.getTimeLine("fsgsd"));
        System.out.println(realService.getTimeLine("nickName"));

        realService.postToTimeLine("nickmName", "Message that we can prevent to send with a proxy");
    }
}
