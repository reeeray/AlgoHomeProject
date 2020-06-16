package patterns.structural.facade;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.05.2020
 **/
public class FacadeDemo {

    public static void main(String[] args) {
        final JdbcFacade facade = new JdbcFacade();

        facade.createTable();
        facade.insertIntoTable();
        final List<JdbcFacade.Address> addresses = facade.getAddresses();
    }
}
