import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 2017-11-22.
 */
public class AnalogClock extends Clock {

    private ClockDisplay view;

    public AnalogClock() {
        super();
        initView(100);
    }

    public AnalogClock(int radius) {
        super();
        initView(radius);
    }

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

    private static class ClockDisplay extends JPanel {

        private int radius;
        private int minutes;
        private int hours;

        public ClockDisplay(int radius) {
            this.radius = radius;
        }

        public void update(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }

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

    public void updateDisplay() {
        view.update(getHours(), getMinutes());
        view.repaint();
    }
}
