package patterns.creational.abstractFactory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class VisaFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(final CardType cardType) {
        switch (cardType) {
            case GOLD :
                return new VisaGoldCreditCard();
            case PLATINUM :
                return new VisaBlackCreditCard();

            default :
                return null;
        }
    }

    @Override
    public Validator getValidator(final CardType cardType) {
        return new VisaValidator();
    }
}
