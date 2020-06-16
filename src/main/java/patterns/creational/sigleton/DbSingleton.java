package patterns.creational.sigleton;

import java.sql.Connection;

/**
 *
 * Common use creational pattern Singleton. Design :
 *  Class is responsible for lifecycle;
 *  Static in nature
 *  Needs to be thread safe
 *  Private instance
 *  Private constructor
 *  No parameters required for constructor
 *
 *  Features :
 *  Lazy loading
 *  Thread safe
 *  Prevention of using Reflection
 *  Using the latest version
 * User : gshein
 * Date : 23.05.2020
 **/
public class DbSingleton {

    //private static DbSingleton instance = new DbSingleton(); //eager instance because it's created in any case whether we use it or not

    private static volatile DbSingleton instance = null; //using the latest version in case of multithreading
    private DbSingleton() {
        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to create instance of this class"); //prevent from Reflection
        }
    }

    public static DbSingleton getInstance() {
        if(instance == null) {
            synchronized (DbSingleton.class) {//Thread safe implementation
                if (instance == null)
                    instance = new DbSingleton(); //lazy creation can improve performance of your app
            }
        }
        return instance;
    }

    public static Connection getConnection() {
        return null;
    }
}
