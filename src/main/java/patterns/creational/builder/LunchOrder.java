package patterns.creational.builder;

import lombok.Getter;

/**
 * Example of Builder Pattern
 * Concepts :
 *      Avoiding telescoping constructors
 *      Maintain immutable object
 * User : gshein
 * Date : 23.05.2020
 **/
@Getter
public class LunchOrder {

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    private LunchOrder(final Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    //internal container class
    public static class Builder{

        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public LunchOrder build () {
            return new LunchOrder(this);
        }

        public Builder bread(final String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments (final String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing (final String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat (final String meat) {
            this.meat = meat;
            return this;
        }

    }
}
