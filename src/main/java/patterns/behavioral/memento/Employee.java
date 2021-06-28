package patterns.behavioral.memento;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Originator according to memento design pattern
 * User : Shein G.A.{@reeeray}
 * Date : 02.11.2020
 **/
@Getter
@Setter
@ToString
public class Employee {

    private String name;
    private String address;
    private String phone;

    public EmployeeMemento save() {
        return new EmployeeMemento(this.name, this.phone);
    }

    public void revert(final EmployeeMemento memento) {
        this.name = memento.getName();
        this.phone = memento.getPhone();
    }
}
