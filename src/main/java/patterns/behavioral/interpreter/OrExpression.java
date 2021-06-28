package patterns.behavioral.interpreter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.10.2020
 **/
public class OrExpression implements Expression {

    final Expression expression1;
    final Expression expression2;

    public OrExpression(final Expression expression1, final Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}
