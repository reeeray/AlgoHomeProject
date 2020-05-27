package patterns.structural.adapter;

/**
 * User : gshein
 * Date : 25.05.2020
 **/
public class AdapterDemo {

    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();

        System.out.println(client.getEmployeeList());
    }
}
