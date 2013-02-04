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

    public void paint(Graphics g) {
        g.setColor(new Color(210, 148, 68));
        g.fillRect(0, 0, 480, 600);

        g.drawImage(background, 0, 0, 400, 600, 0, 0, 400, 600, null);

        inventory.paint(g);

        for (BodyArea b : bodyAreas) {
            b.paint(g);
        }
    }

    /**
     * The entrypoint, create the frame, run the game
     *
     * @param args String arguments (unused)
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        spud = new PotatoHead();

        // set up the window
        frame.setUndecorated(true);
        frame.add(spud);
        frame.pack();
        frame.setSize(480, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseMotionListener(new Mouse());

        spud.start();
    }
}

