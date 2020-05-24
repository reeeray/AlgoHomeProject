package patterns.creational.abstractFactory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class AmexGoldValidator extends Validator {

    @Override
    public boolean isValid(final CreditCard creditCard) {
        return false;
    }
}
