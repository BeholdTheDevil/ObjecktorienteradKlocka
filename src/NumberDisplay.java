/**
 * Created by anton on 2017-11-22.
 */
public class NumberDisplay {
    private int limit;
    private int value;

    public NumberDisplay(int maxLimit) {
        value = 0;
        limit = maxLimit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue < limit && newValue > 0 ? newValue : value;
    }

    public String getDisplayValue() {
        return new String(value < 10 ? "0" + value : "" + value);
    }

    public void increment() {
        value++;
        if(value >= limit) value = 0;
    }
}