package patterns.structural.adapter;

/**
 * User : gshein
 * Date : 25.05.2020
 **/
public class EmployeeAdapterCSV implements Employee {

    private final EmployeeCSV instance;

    public EmployeeAdapterCSV(EmployeeCSV employeeCSV) {
        this.instance = employeeCSV;
    }

    @Override
    public String getId() {
        return "" + instance.getId();
    }

    @Override
    public String getFirstName() {
        return instance.getFirstname();
    }

    @Override
    public String getLastName() {
        return instance.getLastname();
    }

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    }

    //Formally it is part of Decorator pattern
    @Override
    public String toString () {
        return "ID : " + getId() + ", First Name : " + getFirstName() + ", Last Name : " + getLastName() + ", Email : " +getEmail();
    }
}
