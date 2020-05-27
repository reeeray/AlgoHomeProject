package patterns.structural.adapter;

/**
 * User : gshein
 * Date : 25.05.2020
 **/
public class EmployeeAdapterLdap implements Employee {

    private final EmployeeLDAP instance;

    public EmployeeAdapterLdap(EmployeeLDAP employeeLDAP) {
        this.instance = employeeLDAP;
    }

    @Override
    public String getId() {
        return instance.getCn();
    }

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    }

    @Override
    public String getLastName() {
        return instance.getSurname();
    }

    @Override
    public String getEmail() {
        return instance.getMail();
    }

    //it's already part of Decorator Pattern
    @Override
    public String toString () {
         return "ID : " + getId() + ", First Name : " + getFirstName() + ", Last Name : " + getLastName() + ", Email : " +getEmail();
    }
}
