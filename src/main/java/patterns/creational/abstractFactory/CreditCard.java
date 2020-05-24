package patterns.creational.abstractFactory;

import lombok.Getter;
import lombok.Setter;

/**
 * AbstractProduct
 * User : gshein
 * Date : 23.05.2020
 **/
@Getter
@Setter
public abstract class CreditCard {

    protected int cardNumberLength;

    protected int cscNumber;
}
