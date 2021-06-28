package patterns.behavioral.chain_of_responsibility;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2020
 **/
public class CEO extends Handler {

    @Override
    public void handleRequest(Request request) {
        System.out.println("CEOs can approve anything they want.");
    }
}
