package patterns.structural.proxy;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.07.2020
 **/
public class TwitterServiceImpl implements TwitterService {

    private static final String TWITTER_CONSUMER_KEY = "PUT_YOUR_VALUES_HERE";
    private static final String TWITTER_SECRET_KEY = "PUT_YOUR_VALUES_HERE";
    private static final String TWITTER_ACCESS_TOKEN = "PUT_YOUR_VALUES_HERE";
    private static final String TWITTER_ACCESS_TOKEN_SECRET = "PUT_YOUR_VALUES_HERE";

    @Override
    public String getTimeLine(String screenName) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_SECRET_KEY)
                .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        StringBuilder builder = new StringBuilder();
        try {
            Query query = new Query(screenName);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    builder.append("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                    builder.append("\n");
                }
            } while ((query = result.nextQuery()) != null);

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        return builder.toString();
    }

    @Override
    public void postToTimeLine(String screenName, String message) {
        //we aren't going to allow this
    }
}
