package patterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User : gshein
 * Date : 25.05.2020
 **/
public class EmployeeClient {

    public List<Employee> getEmployeeList() {

        final List<Employee> employees = new ArrayList<>();

        final EmployeeDB employeeDB = new EmployeeDB("007", "Grigory", "Shein", "sheingrisha@mail.ru");
        employees.add(employeeDB);

        final EmployeeLDAP employeeLDAP = new EmployeeLDAP("mi6", "Shein", "Gri ", "gshein@phys.msu.ru");
        employees.add(new EmployeeAdapterLdap(employeeLDAP));

        final EmployeeCSV employeeCSV = new EmployeeCSV("1313,SHEIN,GRIGORY,sheingrisha@mail.ru");
        employees.add(new EmployeeAdapterCSV(employeeCSV));


        return employees;
    }
}
