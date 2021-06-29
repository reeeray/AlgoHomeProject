package patterns.functional.validator;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shein G.A. at 02.08.20
 **/
public class ValidatorDemo {

    public static void main(String[] args) {
        Person anya = new Person("Anya", 25);
        Person peter = new Person(null, 25);
        Person alex = new Person("Alexandr", -10);
        Person misha = new Person("Michail", 256);
        Person ksu = new Person(null, 1_000);
        List<Integer> list = new ArrayList<>();

        anya = Validator.validate(p -> p.getName() != null, "The name should not be null")
                        .on(anya)
                        .validate();

        System.out.println(anya);

//        peter = Validator.validate(p -> p.getName() != null, "The name should not be null")
//                .on(peter)
//                .validate();
//
//        System.out.println(peter);

        ksu = Validator.validate(p -> p.getName() != null, "The name should not be null")
                .thenValidate(p -> p.getAge() > 0, "The age should be greater than 0")
                .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150")
                .on(ksu)
                .validate();

        System.out.println(ksu);
    }
}
