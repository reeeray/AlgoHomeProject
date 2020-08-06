package patterns.functional.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Simple POJO
 * Created by Shein G.A. at 02.08.20
 **/
@AllArgsConstructor
@Getter@Setter
@ToString
public class Person {

    private String name;
    private int age;

}
