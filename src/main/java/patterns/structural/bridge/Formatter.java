package patterns.structural.bridge;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public interface Formatter {

    String format(final String header, List<Detail> details);
}
