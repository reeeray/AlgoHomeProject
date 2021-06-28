package patterns.behavioral.memento;

import java.util.Stack;

/**
 * CareTaker
 * User : Shein G.A.{@reeeray}
 * Date : 02.11.2020
 **/
public class CareTaker {

    private Stack<EmployeeMemento> employeeHistory = new Stack<>();

    public void save(final Employee employee) {
        employeeHistory.push(employee.save());
    }

    public void revert(final Employee employee) {
        employee.revert(employeeHistory.pop());
    }
}
