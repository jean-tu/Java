import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class FlowLayoutDemo {
    public static void main(String[] args) {
/*
        Swing events run in the EventDispatchThread. All swing components
        and models must be modified only from the EventDispatchThread.
        SwingUtilities.invokeLater(...) and SwingUtilities.invokeAndWait(...)
        both will execute a Runnable in the EDT.
*/
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame flowLayoutFrame = new JFrame("Flow Layout");
/*
                You shouldn't add components directly to a JFrame. As of Java 5 (1.5?)
                you're allowed to but it won't be backwards compatible. Add to the
                contentPane instead.
*/
                Container contentPane = flowLayoutFrame.getContentPane();
                contentPane.setLayout(new FlowLayout());
                contentPane.add(new JButton("Button A"));

                // buttonB will not be resized smaller than 200x40 pixels
                JButton buttonB = new JButton("Button B");
                buttonB.setPreferredSize(new Dimension(200, 40));
                contentPane.add(buttonB);
                contentPane.add(new JButton("Button C"));
                contentPane.add(new JButton("Button D"));

                flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                flowLayoutFrame.setSize(400, 200);
                flowLayoutFrame.setVisible(true);
            }
        });
    }
}