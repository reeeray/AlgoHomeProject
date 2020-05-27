package patterns.structural.bridge;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public abstract class Printer {

    public String print(final Formatter formatter) {
        return formatter.format(getHeader(), getDetails());
    }

    abstract protected List<Detail> getDetails();

    abstract protected String getHeader();
}
