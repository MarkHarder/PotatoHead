package markharder.potatohead;

import javax.swing.JComponent;
import javax.swing.JFrame;

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

    /**
     * The entrypoint, create the frame, run the game
     *
     * @param args String arguments (unused)
     */
    public static void main(String[] args) {
        spud = new PotatoHead();

        System.out.println(spud);
    }
}

