package patterns.behavioral.memento;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.11.2020
 **/
public class MementoDemo {

    public static void main(String[] args) {

        final CareTaker careTaker = new CareTaker();

        final Employee employee = new Employee();

        employee.setName("Sergey Bodrov");
        employee.setAddress("Moscow is a big city");
        employee.setPhone("89037037700");

        System.out.println("Employee before save " + employee.toString());

        careTaker.save(employee);

        employee.setPhone("89037748334");
        careTaker.save(employee);

        System.out.println("Employee after changing phone number " + employee.toString());

        employee.setPhone("01020304");

        careTaker.revert(employee);

        System.out.println("Employee after first undo " + employee.toString());

        careTaker.revert(employee);

        System.out.println("Employee after second revert " + employee.toString());

    }
}
