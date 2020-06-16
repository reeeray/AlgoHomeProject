package patterns.structural.facade;

import lombok.Getter;
import lombok.Setter;
import patterns.creational.sigleton.DbSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.05.2020
 **/
public class JdbcFacade {

    final DbSingleton instance;

    public JdbcFacade() {
        instance = DbSingleton.getInstance();
    }

    public int createTable() {
        int count = 0;
        try {
            final Connection conn = instance.getConnection();
            final Statement statement = conn.createStatement();
            count = statement.executeUpdate("CREATE TABLE  Addresses (ID INTEGER, StreeName VARCHAR(20), City VARCHAR(20))");
            statement.close();
            conn.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int insertIntoTable() {
        int count = 0;
        try {
            final Connection conn = instance.getConnection();
            final Statement statement = conn.createStatement();
            count = statement.executeUpdate("INSERT INTO Address (ID, StreetName, City) values (1, 'Markt 17E', 'Eindhoven')");
            statement.close();
            conn.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Address> getAddresses() {
        final List<Address> addresses = new ArrayList<>();

        try {
            final Connection conn = instance.getConnection();
            final Statement statement = conn.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM Addresses;");

            while (resultSet.next()) {
                final Address address = new Address();
                address.setId(resultSet.getString(1));
                address.setStreetName(resultSet.getString(2));
                address.setCity(resultSet.getString(3));
                addresses.add(address);
            }
            resultSet.close();
            statement.close();
            conn.close();

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Getter
    @Setter
    class Address {
        private String id;
        private String streetName;
        private String city;
    }
}
