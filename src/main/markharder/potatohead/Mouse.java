package markharder.potatohead;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.awt.Graphics;

/**
 * A class to hold the mouse information
 *
 * @author Mark Harder
 * @version 1.0
 */
public class Mouse implements MouseMotionListener, MouseListener {
    public static Point mse = new Point(0, 0);
    public static Accessory held = null;

    public Mouse() {
    }

    /**
     * Paint the accessory being held
     *
     * @param g the graphics object to be drawn on
     */
    public static void paint(Graphics g) {
        if (held != null) {
            held.paint(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            PotatoHead.spud.click();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mse = new Point(e.getX(), e.getY());

        if (held != null) {
            held.setLocation((int) (e.getX() - held.getWidth() / 2), (int) (e.getY() - held.getHeight() / 2));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mse = new Point(e.getX(), e.getY());

        if (held != null) {
            held.setLocation((int) (e.getX() - held.getWidth() / 2), (int) (e.getY() - held.getHeight() / 2));
        }
    }
}

