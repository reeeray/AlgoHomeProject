package patterns.creational.abstractFactory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(1313);

        final CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(555);

        final CreditCard anotherCard = abstractFactory.getCreditCard(CardType.GOLD);

        System.out.println(anotherCard.getClass());


    }
}
