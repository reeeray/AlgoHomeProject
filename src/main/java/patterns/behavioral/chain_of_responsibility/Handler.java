package patterns.behavioral.chain_of_responsibility;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2020
 **/
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(final Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(final Request request);
}
