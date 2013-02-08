package markharder.potatohead;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
 * Potato head parts
 *
 * @author Mark Harder
 * @version 1.0
 */
public class Accessory extends Rectangle {
    public static final int SIZE = 80;

    private static BufferedImage tileset_features;
    private int id;

    static {
        try {
            tileset_features = ImageIO.read(new File("res/tileset_features.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create an accessory at (x, y) with dimensions (width, height) and an id
     *
     * @param x the x location on the screen
     * @param y the y locatoin on the screen
     * @param width the accessory width
     * @param height the accessory height
     * @param id which accessory it is
     */
    public Accessory(int x, int y, int width, int height, int id) {
        setBounds(PotatoHead.CORNER_X + x, PotatoHead.CORNER_Y + y, width, height);
        this.id = id;
    }

    /**
     * A copy constructor
     *
     * @param a the accessory to copy
     */
    public Accessory(Accessory a) {
        setBounds((int) a.getX(), (int) a.getY(), (int) a.getWidth(), (int) a.getHeight());
        this.id = a.getID();
    }

    /**
     * return the id
     *
     * @return the accessory id
     */
    public int getID() {
        return id;
    }

    /**
     * Paint the accessory
     *
     * @param g The graphics object drawn on
     */
    public void paint(Graphics g) {
        g.drawImage(tileset_features, x, y, x + width, y + height, 0, id * SIZE, SIZE, SIZE + id * SIZE, null);
    }
}

