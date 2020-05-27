package patterns.structural.adapter;

import lombok.Getter;

/**
 * LDAP - Lightweight Directory Access Protocol
 * User : gshein
 * Date : 25.05.2020
 **/
@Getter
public class EmployeeLDAP {

    private String cn;
    private String surname;
    private String givenName;
    private String mail;

    public EmployeeLDAP(final String cn, final String surname, final String givenName, final String mail) {
        this.cn = cn;
        this.surname = surname;
        this.givenName = givenName;
        this.mail = mail;
    }
}
