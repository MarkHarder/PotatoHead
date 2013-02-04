package markharder.potatohead;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Point;

/**
 * A class to hold the mouse information
 *
 * @author Mark Harder
 * @version 1.0
 */
public class Mouse implements MouseMotionListener {
    public static Point mse = new Point(0, 0);

    public Mouse() {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mse = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mse = new Point(e.getX(), e.getY());
    }
}

