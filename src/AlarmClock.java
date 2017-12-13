import java.awt.*;

/**
 * Created by anton on 2017-11-22.
 */
public class AlarmClock extends Clock {

    private int alarmHour;
    private int alarmMinute;
    private boolean alarm = false;

    /**
     * Constructor simply calls Clock constructor.
     * @see Clock#Clock()
     */
    public AlarmClock() {
        super();
    }

    /**
     * @see Clock#Clock(int, int)
     * @param hour The desired hour as an Integer.
     * @param minute The desired minute as an Integer.
     */
    public AlarmClock(int hour, int minute) {
        super(hour, minute);
    }

    /**
     * @see Clock#Clock(boolean)
     * @param s Boolean deciding wether the clock is a 24- or 12hour model.
     */
    public AlarmClock(boolean s) {
        super(s);
    }

    /**
     * @see Clock#Clock(int, int, boolean)
     * @param hour The desired hour as an Integer.
     * @param minute The desired minute as an Integer.
     * @param s Boolean deciding wether the clock is a 24- or 12hour model.
     */
    public AlarmClock(int hour, int minute, boolean s) {
        super(hour, minute, s);
    }

    /**
     * Sets an alarm to the parameter defined hour and minute.
     * @param h The desired hour as an Integer.
     * @param m The desired minute as an Integer.
     */
    public void setAlarm(int h, int m) {
        alarmHour = h;
        alarmMinute = m;
    }

    public void alarmOn() {
        alarm = true;
    }

    public void alarmOff() {
        alarm = false;
    }

    public void snooze() {
        snooze(10);
    }

    /**
     * Delays the alarm for the parameter defined minutes.
     * @param minutes The amount of delay in minutes as an Integer.
     */
    public void snooze(int minutes) {
        alarmMinute += minutes;
        alarmHour += alarmMinute / 60;
        alarmMinute = alarmMinute % 60;
        alarmHour = alarmHour % 24;
    }

    /**
     * Increments the time and checks if the alarm is triggered.
     * @see Clock#timeTick()
     */
    @Override
    public void timeTick() {
        super.timeTick();
        if(alarm && (super.getHours() == alarmHour && super.getMinutes() == alarmMinute)) {
            //Toolkit.getDefaultToolkit().beep();
            System.out.println("Ring ring");
        }
    }

    /**
     * @return A String representation of the current time and the time of the alarm.
     */
    @Override
    public String getTime() {
        return super.getTime() + "\tAlarm: " + (alarmHour < 10 ? "0" + alarmHour : alarmHour) + ":" + (alarmMinute < 10 ? "0" + alarmMinute : alarmMinute);
    }
}
