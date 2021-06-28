package patterns.behavioral.chain_of_responsibility;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2020
 **/
public class Director extends Handler {

    @Override
    public void handleRequest(final Request request) {
        if (request.getRequestType() == RequestType.CONFERENCE) {
            System.out.println("Director can approve conferences.");
        } else {
            successor.handleRequest(request);
        }
    }
}
