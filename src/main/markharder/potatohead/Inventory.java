package markharder.potatohead;

import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A place to store the accessories
 *
 * @author Mark Harder
 * @version 1.0
 */
public class Inventory {
    // image for scrolling arrows
    private BufferedImage tilesetArrows;

    private ArrayList<Accessory> accessories;

    /**
     * Load the arrow images
     */
    public Inventory() {
        try {
            tilesetArrows = ImageIO.read(new File("res/tileset_arrows.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        accessories = new ArrayList<Accessory>();

        for (int i = 0; i < 8; i++) {
            accessories.add(new Accessory(400, 40 + i * Accessory.SIZE, Accessory.SIZE, Accessory.SIZE, i));
        }
    }

    /**
     * Paint the items and arrows
     *
     * @param g The graphics object drawn on
     */
    public void paint(Graphics g) {
        for (Accessory a : accessories) {
            if (a.contains(Mouse.mse)) {
                int x = (int) a.getX();
                int y = (int) a.getY();
                int width = (int) a.getWidth();
                int height = (int) a.getHeight();

                g.setColor(new Color(255, 255, 255, 60));
                g.fillRect(x, y, width, height);
            }

            a.paint(g);
        }

        // draw up and down arrows
        g.drawImage(tilesetArrows, 400, 0, 480, 40, 0, 0, 80, 40, null);
        g.drawImage(tilesetArrows, 400, 560, 480, 600, 0, 40, 80, 80, null);
    }
}

