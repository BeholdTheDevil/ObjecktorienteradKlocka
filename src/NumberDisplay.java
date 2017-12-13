/**
 * Created by anton on 2017-11-22.
 */
public class NumberDisplay {
    private int limit;
    private int value;

    /**
     * Constructor of a NumberDisplay with a parameter defined limit.
     * @param maxLimit
     */
    public NumberDisplay(int maxLimit) {
        value = 0;
        limit = maxLimit;
    }

    /**
     * @return The current Integer value of the NumberDisplay.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the current value of the NumberDisplay to parameter defined new value.
     * @param newValue Integer between zero and the limit.
     */
    public void setValue(int newValue) {
        value = newValue < limit && newValue >= 0 ? newValue : value;
    }

    /**
     * @return A String representation of the numerical value of the NumberDisplay.
     */
    public String getDisplayValue() {
        return new String(value < 10 ? "0" + value : "" + value);
    }

    /**
     * Increment the current value by one and roll over to zero if the limit is reached.
     */
    public void increment() {
        value++;
        if(value >= limit) value = 0;
    }
}