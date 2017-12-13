/**
 * Created by anton on 2017-11-22.
 */
public class Clock {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;
    private boolean meridian = true;
    private boolean format = false;

    /**
     * Constructor of 24hour clock with time zero.
     */
    public Clock() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);

        updateDisplay();
    }

    /**
     * Constructor of clock with parameter defined starttime.
     * @param hour Integer for desired hour.
     * @param minute Integer for desired minute.
     */
    public Clock(int hour, int minute) {
        hours = new NumberDisplay(24);
        hours.setValue(hour);

        minutes = new NumberDisplay(60);
        minutes.setValue(minute);

        updateDisplay();
    }

    /**
     * Constructor of 24- or 12hour clock as defined by s.
     * @param s Boolean deciding wether the clock is a 24- or 12hour model.
     */
    public Clock(boolean s) {
        format = s;
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);

        updateDisplay();
    }

    /**
     * Constructor of clock with parameter defined starttime and either a 24- or 12hour model.
     * @param hour Integer for the hour the clock to starts at.
     * @param minute Integer for the minute the clock starts at.
     * @param s Boolean deciding wether the clock is a 24- or 12hour model.
     */
    public Clock(int hour, int minute, boolean s) {
        format = s;
        hours = new NumberDisplay(24);
        hours.setValue(hour);

        minutes = new NumberDisplay(60);
        minutes.setValue(minute);

        updateDisplay();
    }

    /**
     * Ticks the time forward using NumberDisplay increment() and rolls over when it's max is reached.
     * @see NumberDisplay#increment()
     */
    public void timeTick() {
        minutes.increment();
        if(minutes.getValue() == 0) {
            hours.increment();
            if(format && hours.getValue() % 12 == 1) {
                meridian = !meridian;
            }
        }

        updateDisplay();
    }

    /**
     * Sets the time as defined by parameters and updates the display.
     * @see #updateDisplay()
     * @param hour Integer for desired hour.
     * @param minute Integer for desired minute.
     */
    public void setTime(int hour, int minute) {
        hours.setValue(hour);
        minutes.setValue(minute);

        updateDisplay();
    }

    /**
     * Inverts format so that the 24hour clock becomes a 12hour display and vice versa.
     */
    public void switchFormat() {
        format = !format;
    }

    /**
     * Returns the time in String format.
     * @see #updateDisplay() For updating of the String that is returned.
     * @return The time as a String
     */
    public String getTime() {
        return displayString;
    }

    /**
     * @return Current hour as an Integer.
     */
    protected int getHours() {
        return hours.getValue();
    }

    /**
     * @return Current minute as a Integer.
     */
    protected int getMinutes() {
        return minutes.getValue();
    }

    /**
     * Updates the displayString, behaviour changes depending on wether 24- or 12hour display is currently selected.
     */
    private void updateDisplay() {
        if(format) {
            int h = hours.getValue() % 12;
            if(h == 0) h += 12;
            displayString = (h < 10 ? "0" + h : h) + ":" + minutes.getDisplayValue() + (meridian ? " AM" : " PM");
        } else {
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
        }
    }
}
