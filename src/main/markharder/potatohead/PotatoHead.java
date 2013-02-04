package markharder.potatohead;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

/**
 * A potato head accessorizor
 *
 * @author Mark Harder
 * @version 1.0
 */
public class PotatoHead extends JComponent {
    public static PotatoHead spud;

    public PotatoHead() {
    }

    public void paint(Graphics g) {
        g.setColor(new Color(100, 10, 10));
        g.fillRect(0, 0, 480, 600);
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

