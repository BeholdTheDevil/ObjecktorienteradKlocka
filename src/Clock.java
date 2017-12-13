/**
 * Created by anton on 2017-11-22.
 */
public class Clock {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;
    private boolean meridian = true;
    private boolean format = false;

    public Clock() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);

        updateDisplay();
    }

    public Clock(int hour, int minute) {
        hours = new NumberDisplay(24);
        hours.setValue(hour);

        minutes = new NumberDisplay(60);
        minutes.setValue(minute);

        updateDisplay();
    }

    public Clock(boolean s) {
        format = s;
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);

        updateDisplay();
    }

    public Clock(int hour, int minute, boolean s) {
        format = s;
        hours = new NumberDisplay(24);
        hours.setValue(hour);

        minutes = new NumberDisplay(60);
        minutes.setValue(minute);

        updateDisplay();
    }

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

    public void setTime(int hour, int minute) {
        hours.setValue(hour);
        minutes.setValue(minute);

        updateDisplay();
    }

    public void switchFormat() {
        format = !format;
    }

    public String getTime() {
        return displayString;
    }

    protected int getHours() {
        return hours.getValue();
    }

    protected int getMinutes() {
        return minutes.getValue();
    }

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
