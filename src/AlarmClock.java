import java.awt.*;

/**
 * Created by anton on 2017-11-22.
 */
public class AlarmClock extends Clock {

    private int alarmHour;
    private int alarmMinute;
    private boolean alarm = false;

    public AlarmClock() {
        super();
    }

    public AlarmClock(int hour, int minute) {
        super(hour, minute);
    }

    public AlarmClock(boolean s) {
        super(s);
    }

    public AlarmClock(int hour, int minute, boolean s) {
        super(hour, minute, s);
    }

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

    public void snooze(int minutes) {
        alarmMinute += minutes;
        alarmHour += alarmMinute / 60;
        alarmMinute = alarmMinute % 60;
        alarmHour = alarmHour % 24;
    }

    @Override
    public void timeTick() {
        super.timeTick();
        if(alarm && (super.getHours() == alarmHour && super.getMinutes() == alarmMinute)) {
            //Toolkit.getDefaultToolkit().beep();
            System.out.println("Ring ring");
        }
    }

    @Override
    public String getTime() {
        return super.getTime() + "\tAlarm: " + (alarmHour < 10 ? "0" + alarmHour : alarmHour) + ":" + (alarmMinute < 10 ? "0" + alarmMinute : alarmMinute);
    }
}
