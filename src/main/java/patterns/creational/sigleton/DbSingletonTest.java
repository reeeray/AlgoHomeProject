package patterns.creational.sigleton;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class DbSingletonTest {

    public static void main(String[] args) {
        final DbSingleton instance = DbSingleton.getInstance();
        final DbSingleton anotherInstance = DbSingleton.getInstance();
        assert instance == anotherInstance : "It's not a singleton!";
    }
}
