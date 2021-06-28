package patterns.functional.comparator;

import patterns.functional.function.Function;

/**
 * Created by Shein G.A. at 26.07.20
 **/
public class ComparatorDemo {

    public static void main(String[] args) {
        final Person person1 = new Person("Grigory", 25);
        final Person person2 = new Person("George", 45);
        final Person person3 = new Person("Alina", 34);
        final Person person4 = new Person("Yana", 27);
        final Person oldYana = new Person("Yana", 30);

        final Function<Person, String> getName = Person::getName;
        final Function<Person, Integer> getAge = Person::getAge;
        final Comparator<Person> cmpName = Comparator.comparing(getName);
        final Comparator<Person> cmpAge = Comparator.comparing(getAge);
        final Comparator<Person> cmpNameReversed = cmpName.reversed();

        final Comparator<Person> cmp = Comparator.comparing(Person::getName).thenComparing(Person::getAge);

        System.out.println("George > Grigory : " + (cmpName.compare(person1, person2) > 0));
        System.out.println("Alina > Yana : " + (cmpName.compare(person3, person4) > 0));
        System.out.println("Grigory > Yana : " + (cmpName.compare(person1, person4) > 0));
        System.out.println("Alina > Yana : " + (cmpNameReversed.compare(person3, person4) > 0));
        System.out.println("Grigory > Yana : " + (cmpNameReversed.compare(person1, person4) > 0));
        System.out.println("Elder Yand > Yana : " + (cmp.compare(oldYana, person4) > 0));

    }
}
