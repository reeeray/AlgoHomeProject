package patterns.structural.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public class MoviePrinter extends Printer {

    private Movie movie;

    public MoviePrinter(final Movie movie) {
        this.movie = movie;
    }

    @Override
    protected List<Detail> getDetails() {
        final List<Detail> details = new ArrayList<>();

        details.add(new Detail("Title", movie.getTitle()));
        details.add(new Detail("Year", movie.getYear()));
        details.add(new Detail("Runtime", movie.getRuntime()));

        return details;
    }

    @Override
    protected String getHeader() {
        return movie.getClassification();
    }
}
