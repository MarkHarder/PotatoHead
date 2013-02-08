package markharder.potatohead;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A potato head accessorizor
 *
 * @author Mark Harder
 * @version 1.0
 */
public class PotatoHead extends JComponent {
    private BufferedImage background;
    private Inventory inventory;
    private ArrayList<BodyArea> bodyAreas;

    private static boolean running = false;

    public static PotatoHead spud;

    public static int WIDTH = 480;
    public static int HEIGHT = 600;
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static int CORNER_X;
    public static int CORNER_Y;

    public PotatoHead() {
        try {
            background = ImageIO.read(new File("res/potato.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        inventory = new Inventory();

        bodyAreas = new ArrayList<BodyArea>();

        // create the three body areas to place accessories on
        bodyAreas.add(new BodyArea(145, 160, 120, 120));
        bodyAreas.add(new BodyArea(145, 245, 120, 120));
        bodyAreas.add(new BodyArea(145, 360, 120, 120));
    }

    /**
     * Stop the game from running
     */
    public void stop() {
        running = false;
    }

    /**
     * The loop that continuously paints the components
     */
    public void start() {
        running = true;

        while (running) {
            repaint();
        }
    }

    /**
     * Calls the click methods of all the components
     */
    public void click() {
        inventory.click();

        for (BodyArea b : bodyAreas) {
            b.click();
        }
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        g.setColor(new Color(210, 148, 68));
        g.fillRect(CORNER_X, CORNER_Y, 480, 600);

        g.drawImage(background, CORNER_X, CORNER_Y, CORNER_X + 400, CORNER_Y + 600, 0, 0, 400, 600, null);

        inventory.paint(g);

        for (BodyArea b : bodyAreas) {
            b.paint(g);
        }

        Mouse.paint(g);
    }

    /**
     * The entrypoint, create the frame, run the game
     *
     * @param args String arguments (unused)
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setUndecorated(true);
        frame.pack();

        // set up the window
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        SCREEN_WIDTH = frame.getWidth();
        SCREEN_HEIGHT = frame.getHeight();
        CORNER_X = (SCREEN_WIDTH - WIDTH) / 2;
        CORNER_Y = (SCREEN_HEIGHT - HEIGHT) / 2;

        spud = new PotatoHead();

        frame.add(spud);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Mouse m = new Mouse();
        frame.addMouseMotionListener(m);
        frame.addMouseListener(m);

        spud.start();
    }
}

