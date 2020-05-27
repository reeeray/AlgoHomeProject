package patterns.structural.bridge;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public class BridgeDemo {

    public static void main(String[] args) {
        final Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("2:15");
        movie.setYear("2014");

        Formatter printFormatter = new PrintFormatter();
        Printer moviePrinter = new MoviePrinter(movie);

        String printedMaterial = moviePrinter.print(printFormatter);

        final Formatter htmlFormatter = new HtmlFormatter();

        final String html = moviePrinter.print(htmlFormatter);


        System.out.println(printedMaterial);
        System.out.println(html );
    }
}
