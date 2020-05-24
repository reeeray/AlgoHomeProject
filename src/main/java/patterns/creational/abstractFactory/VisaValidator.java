package patterns.creational.abstractFactory;

/**
 * User : gshein
 * Date : 23.05.2020
 **/
public class VisaValidator extends Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
