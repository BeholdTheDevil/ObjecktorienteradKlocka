import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 2017-11-22.
 */
public class AnalogClock extends Clock {

    private ClockDisplay view;

    /**
     * Creates a clock and initializes a 100*100px window with an analog clock.
     */
    public AnalogClock() {
        super();
        initView(100);
    }

    /**
     * Creates a clock and initializes a user defined window size containing an analog clock.
     * @param radius An Integer with the desired radius of the clock in pixels.
     */
    public AnalogClock(int radius) {
        super();
        initView(radius);
    }

    /**
     * Creates the actual analog clock with a parameter defined radius.
     * @see ClockDisplay
     * @param radius An Integer with the desired radius of the clock in pixels.
     */
    private void initView(int radius) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(2*radius + 10, 2*radius + 10));

        view = new ClockDisplay(radius);
        view.setPreferredSize(new Dimension(2*radius + 10, 2*radius + 10));
        view.setDoubleBuffered(true);
        view.setVisible(true);
        view.setBackground(new Color(51, 51, 51));

        frame.add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        updateDisplay();
    }

    /**
     * Updates the clock and repaints the window.
     * @see ClockDisplay#update(int, int)
     */
    public void updateDisplay() {
        view.update(getHours(), getMinutes());
        view.repaint();
    }


    private static class ClockDisplay extends JPanel {

        private int radius;

        private int minutes;
        private int hours;

        /**
         * Creates a ClockDisplay and sets it's radius to the parameter.
         * @param radius The radius of the ClockDisplay as an Integer.
         */
        public ClockDisplay(int radius) {
            this.radius = radius;
        }

        /**
         * Sets the value of the hours and minutes.
         * @param hours The desired hour as an Integer.
         * @param minutes The desired minute as an Integer.
         */
        public void update(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }

        /**
         * Paints the analog clock on the ClockDisplay-JPanel.
         * @see Graphics
         * @see Graphics2D
         * @see JPanel#paint(Graphics)
         * @see JPanel#repaint()
         * @param g The Graphics to paint upon.
         */
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(new Color(220, 220, 220));

            //Draw static clock objects
            g2d.drawOval(5, 5, 2*radius, 2*radius);
            g2d.fillOval(radius + 2, radius + 2, 6, 6);
            g2d.drawLine(5, 5 + radius, 15, 5 + radius);
            g2d.drawLine(5 + radius, 5, 5 + radius, 15);
            g2d.drawLine(2 * radius - 5, 5 + radius, 2 * radius + 5, 5 + radius);
            g2d.drawLine(5 + radius, 2 * radius - 5, 5 + radius, 2 * radius + 5);


            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(radius + 5, radius + 5, 5 + radius + (int)(0.9 * radius * Math.cos(Math.PI * minutes / 30 - Math.PI*0.5)), 5 + radius + (int)(0.9 * radius * Math.sin(Math.PI * minutes / 30 - Math.PI*0.5)));
            g2d.setStroke(new BasicStroke(4));
            g2d.drawLine(radius + 5, radius + 5, 5 + radius + (int)(0.6 * radius * Math.cos(Math.PI * hours / 6 - Math.PI*0.5)), 5 + radius + (int)(0.6 * radius * Math.sin(Math.PI * hours / 6 - Math.PI*0.5)));
        }
    }
}
