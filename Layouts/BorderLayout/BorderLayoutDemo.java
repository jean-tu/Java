import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Container;

public class BorderLayoutDemo {
    public static void main(String[] args) {
/*
        Swing events run in the EventDispatchThread. All swing components
        and models must be modified only from the EventDispatchThread.
        SwingUtilities.invokeLater(...) and SwingUtilities.invokeAndWait(...)
        both will execute a Runnable in the EDT.
*/
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame borderLayoutFrame = new JFrame("Border Layout");
/*
                You shouldn't add components directly to a JFrame. As of Java 5 (1.5?)
                you're allowed to but it won't be backwards compatible. Add to the
                contentPane instead.
*/
                Container contentPane = borderLayoutFrame.getContentPane();
                contentPane.setLayout(new BorderLayout());
                contentPane.add(new JButton("East Button"), BorderLayout.EAST);
                contentPane.add(new JButton("West Button"), BorderLayout.WEST);
                contentPane.add(new JButton("North Button"), BorderLayout.NORTH);
                contentPane.add(new JButton("South Button"), BorderLayout.SOUTH);
                contentPane.add(new JButton("Center"), BorderLayout.CENTER);

                borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                borderLayoutFrame.setSize(400, 200);
                borderLayoutFrame.setVisible(true);
            }
        });
    }
}