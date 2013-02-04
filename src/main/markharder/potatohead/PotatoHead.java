package markharder.potatohead;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * A potato head accessorizor
 *
 * @author Mark Harder
 * @version 1.0
 */
public class PotatoHead extends JComponent {
    private BufferedImage background;

    public static PotatoHead spud;

    public PotatoHead() {
        try {
            background = ImageIO.read(new File("res/potato.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.setColor(new Color(210, 148, 68));
        g.fillRect(0, 0, 480, 600);

        g.drawImage(background, 0, 0, 400, 600, 0, 0, 400, 600, null);
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
    }
}

