package patterns.structural.adapter;

import lombok.Getter;

import java.util.StringTokenizer;

/**
 * User : gshein
 * Date : 25.05.2020
 **/
@Getter
public class EmployeeCSV {

    private int id;
    private String firstname;
    private String lastname;
    private String emailAddress;


    public EmployeeCSV(final String s) {
        final StringTokenizer tokenaizer = new StringTokenizer(s, ",");
        if(tokenaizer.hasMoreElements()) {
            id = Integer.parseInt(tokenaizer.nextToken());
        }
        if(tokenaizer.hasMoreElements()) {
            firstname = tokenaizer.nextToken();
        }
        if(tokenaizer.hasMoreElements()) {
            lastname = tokenaizer.nextToken();
        }
        if (tokenaizer.hasMoreElements()) {
            emailAddress = tokenaizer.nextToken();
        }
    }
}
