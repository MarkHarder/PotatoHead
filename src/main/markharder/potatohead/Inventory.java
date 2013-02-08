package markharder.potatohead;

import java.awt.Rectangle;
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

    // the amount the inventory has been shifted
    private int scrollIndex = 0;

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
     * Pick up and put down accessories or scroll up and down
     */
    public void click() {
        Rectangle upArrow = new Rectangle(PotatoHead.CORNER_X + 400, PotatoHead.CORNER_Y + 0, 80, 40);
        Rectangle downArrow = new Rectangle(PotatoHead.CORNER_X + 400, PotatoHead.CORNER_Y + 560, 80, 40);

        if (upArrow.contains(Mouse.mse)) {
            scrollUp();
        } else if (downArrow.contains(Mouse.mse)) {
            scrollDown();
        } else {
            for (Accessory a : accessories) {
                if (a.contains(Mouse.mse)) {
                    // put an accessory down
                    if (Mouse.held != null && Mouse.held.getID() == a.getID()) {
                        Mouse.held = null;
                    // take an accessory
                    } else {
                        Mouse.held = new Accessory(a);
                    }
                }
            }
        }
    }

    // scroll the items up
    private void scrollUp() {
        if (scrollIndex == 0) {
            return;
        }

        scrollIndex -= 1;

        for (Accessory a: accessories) {
            a.translate(0, Accessory.SIZE);
        }
    }

    // scroll the items down
    private void scrollDown() {
        if (scrollIndex == 2) {
            return;
        }

        scrollIndex += 1;

        for (Accessory a : accessories) {
            a.translate(0, -Accessory.SIZE);
        }
    }

    /**
     * Paint the items and arrows
     *
     * @param g The graphics object drawn on
     */
    public void paint(Graphics g) {
        for (int i = scrollIndex; i < scrollIndex + 6; i++) {
            Accessory a = accessories.get(i);
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
        g.drawImage(tilesetArrows, PotatoHead.CORNER_X + 400, PotatoHead.CORNER_Y + 0, PotatoHead.CORNER_X + 480, PotatoHead.CORNER_Y + 40, 0, 0, 80, 40, null);
        g.drawImage(tilesetArrows, PotatoHead.CORNER_X + 400, PotatoHead.CORNER_Y + 560, PotatoHead.CORNER_X + 480, PotatoHead.CORNER_Y + 600, 0, 40, 80, 80, null);
    }
}

