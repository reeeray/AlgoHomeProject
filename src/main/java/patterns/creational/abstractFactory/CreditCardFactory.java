package patterns.creational.abstractFactory;

/**
 * Abstract Factory pattern
 * User : gshein
 * Date : 23.05.2020
 **/
public abstract class CreditCardFactory {

    public static final int AMOUNT_SUM = 650;

    public static CreditCardFactory getCreditCardFactory(final int creditStore) {
        if(creditStore > AMOUNT_SUM) {
            return new AmexFactory();
        } else {
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(final CardType cardType);

    public abstract Validator getValidator(final CardType cardType);
}
