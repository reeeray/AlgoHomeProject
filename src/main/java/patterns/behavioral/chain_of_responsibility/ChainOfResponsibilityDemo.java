package patterns.behavioral.chain_of_responsibility;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2020
 **/
public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        final Director grigory = new Director();
        final VP abel = new VP(); //vice president
        final CEO thijs = new CEO();

        grigory.setSuccessor(abel);
        abel.setSuccessor(thijs);

        Request request = new Request(RequestType.CONFERENCE, 500);
        grigory.handleRequest(request);

        request = new Request(RequestType.PURCHASE, 1000);
        grigory.handleRequest(request);

        request = new Request(RequestType.PURCHASE, 2000);
        grigory.handleRequest(request);
    }
}
