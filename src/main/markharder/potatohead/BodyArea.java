package markharder.potatohead;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Represents a place to put an accessory on the potato
 *
 * @author Mark Harder
 * @version 1.0
 */
public class BodyArea extends Rectangle {
    /**
     * Create a body area at (x, y) with dimensions (width, height)
     *
     * @param x the x location on screen
     * @param y the y locatoin on screen
     * @param width the body area width
     * @param height the body area height
     */
    public BodyArea(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    /**
     * Draw the area
     *
     * @param g The graphics object drawn on
     */
    public void paint(Graphics g) {
        g.setColor(new Color(255, 255, 255, 30));
        g.fillRect(x, y, width, height);

        g.setColor(new Color(0, 0, 0));
        g.fillOval(x - 6 + width / 2, y - 6 + height / 2, 12, 12);

        if (contains(Mouse.mse)) {
            g.setColor(new Color(255, 255, 255, 60));
            g.fillRect(x, y, width, height);
        }
    }
}

