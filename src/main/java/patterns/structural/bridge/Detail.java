package patterns.structural.bridge;

import lombok.Getter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
@Getter
public class Detail {

    private String label;
    private String value;

    public Detail(final String label, final String value) {
        this.label = label;
        this.value = value;
    }
}
