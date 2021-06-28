package patterns.behavioral.interpreter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.10.2020
 **/
public class InterpreterDemo {

    static Expression buildInterpreterTree() {

        final Expression terminal1 = new TerminalExpression("Lions");
        final Expression terminal2 = new TerminalExpression("Bears");
        final Expression terminal3 = new TerminalExpression("Tigers");

        //Bears and Tigers
        final Expression alternation1 = new AndExpression(terminal2, terminal3);
        //Lions OR (Bears and Tigers)
        final Expression alternation2 = new OrExpression(terminal1, alternation1);

        return new AndExpression(terminal3, alternation2);
    }

    /**
     * main method - build the interpreter and then interpret a specific sequence
     *
     * @param args
     */
    public static void main(String[] args) {
//        final String context = "Lions and Bears";
//        final String context = "Bears";
        final String context = "Lamas Bears Tigers";


        final Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));

    }
}

