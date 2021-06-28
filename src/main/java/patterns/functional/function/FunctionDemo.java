package patterns.functional.function;

/**
 * Created by Shein G.A. at 26.07.20
 **/
public class FunctionDemo {

    public static void main(String[] args) {
        final Meteo meteo = new Meteo(20);

        final Function<Meteo, Integer> readCelcius = m -> m.getTemperature();
        final Function <Integer, Double> celciusToFarenheit = c -> c*9D/5.D + 32.D;

        //chainable function
        Function<Meteo, Double> readFarenheit = readCelcius.andThen(celciusToFarenheit);

        System.out.println("20 C equals " + readFarenheit.apply(meteo) + " F");

        //the same using composition
        readFarenheit = celciusToFarenheit.compose(readCelcius);
        System.out.println("20 C equals " + readFarenheit.apply(meteo)+ " F");

        //static methods also can be used as factory methods in functional interfaces
        final Function<String, String> identity = Function.identity();

    }
}
