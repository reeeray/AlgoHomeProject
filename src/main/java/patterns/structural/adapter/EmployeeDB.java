package patterns.structural.adapter;

import lombok.Getter;

/**
 * User : gshein
 * Date : 25.05.2020
 **/
@Getter
public class EmployeeDB implements Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDB(final String id, final String firstName, final String lastName, final String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString () {
        return "ID : " + getId() + ", First Name : " + getFirstName() + ", Last Name : " + getLastName() + ", Email : " +getEmail();
    }
}
