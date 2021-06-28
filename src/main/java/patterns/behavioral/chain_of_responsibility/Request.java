package patterns.behavioral.chain_of_responsibility;

import lombok.Getter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2020
 **/
public class Request {

    @Getter
    private RequestType requestType;
    @Getter
    private double amount;

    public Request(final RequestType requestType, final double amount) {
        this.requestType = requestType;
        this.amount = amount;
    }
}
