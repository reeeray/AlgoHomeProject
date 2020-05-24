package patterns.creational.prototype;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class PrototypeDemo {

    public static void main(String[] args) {
        final Registry registry = new Registry();
        final Movie movie = (Movie) registry.createItem("Movie");
        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getPrice());
        movie.setTitle("Filth Filth Filth. Triple Filth");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getPrice());

        final Movie anotherMovie = (Movie) registry.createItem("Movie");
        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getPrice());
        anotherMovie.setTitle("Brat 2");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getPrice());

    }
}
