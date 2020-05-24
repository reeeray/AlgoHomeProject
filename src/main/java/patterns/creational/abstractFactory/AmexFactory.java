package patterns.creational.abstractFactory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class AmexFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(final CardType cardType) {

        switch (cardType) {
            case GOLD:
                return new AmexGoldCreditCard();
            case PLATINUM:
                return new AmexPlatinumCreditCard();
            default:
                return null;
        }
    }

    @Override
    public Validator getValidator (final CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new AmexGoldValidator();
            case PLATINUM:
                return new AmexPlatinumValidator();
            default :
                return null;
        }
    }
}
