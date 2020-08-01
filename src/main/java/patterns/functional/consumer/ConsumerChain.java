package patterns.functional.consumer;

/**
 * Created by Shein G.A. at 26.07.20
 **/
public class ConsumerChain {

    public static void main(String[] args) {
        final Consumer<String> c1 = c -> System.out.println("consumer 1 : " + c);
        final Consumer<String> c2 = c -> System.out.println("consumer 2 : " + c);

        //bad practice, dirty
        final Consumer<String> c3 = c -> {
            c1.accept(c);
            c2.accept(c);
        };

        final Consumer<String> c4 = c1.andThen(c2);

    }
}
