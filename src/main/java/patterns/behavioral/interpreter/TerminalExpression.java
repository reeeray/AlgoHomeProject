package patterns.behavioral.interpreter;

import java.util.StringTokenizer;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.10.2020
 **/
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(final String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        final StringTokenizer st = new StringTokenizer(context);
        while (st.hasMoreTokens()) {
            final String test = st.nextToken();
            if (test.equals(data))
                return true;
        }
        return false;
    }
}
