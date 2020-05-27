package patterns.structural.bridge;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public class PrintFormatter implements Formatter {

    @Override
    public String format(String header, List<Detail> details) {
        final StringBuilder sb = new StringBuilder();

        sb.append(header);
        sb.append("\n ");

        for(Detail detail : details) {
            sb.append(detail.getLabel());
            sb.append(detail.getValue());
        }

        return sb.toString();
    }
}
