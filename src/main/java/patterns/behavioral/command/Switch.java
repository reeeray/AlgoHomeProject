package patterns.behavioral.command;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2020
 **/
public class Switch {

    public void storeAndExecute(final Command command) {
        command.execute();
    }
}
