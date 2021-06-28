package patterns.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Memento itself. You can adjust this class with parameters according to your needs.
 * User : Shein G.A.{@reeeray}
 * Date : 02.11.2020
 **/
@AllArgsConstructor
@Getter
public class EmployeeMemento {

    private String name;
    private String phone;
}
