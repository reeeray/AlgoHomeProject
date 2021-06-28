package patterns.behavioral.chain_of_responsibility;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2020
 **/
public class VP extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.PURCHASE) {
            if (request.getAmount() < 1500) {
                System.out.println("Vice president can approve purchases below 1500.");
            } else {
                successor.handleRequest(request);
            }
        }
    }
}
