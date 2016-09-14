import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GridLayoutDemo extends JFrame {

    private static final long serialVersionUID = 1L;

    public GridLayoutDemo() {
        /*
         * Calls the constructor in superclass.
         */
        super("GridLayout Demo");

        /*
         * Sets the close operation to DISPOSE_ON_CLOSE.
         */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /*
         * Creates a new GridLayout object. It has 2 rows and any number of
         * columns depending of the component count on container. The horizontal
         * and vertical gaps are 10 and 15, respectively.
         */
        GridLayout layout = new GridLayout(2, 0, 10, 15);

        /*
         * The default layout manager for the JFrame's content pane is
         * BorderLayout. So, we must to change it.
         */
        setLayout(layout);

        /*
         * Just add the new components.
         */
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JLabel("Label 1", SwingConstants.CENTER));
        add(new JCheckBox("CheckBox 1"));
        add(new JLabel("Label 2", SwingConstants.CENTER));
        add(new JLabel("Label 3", SwingConstants.CENTER));
        add(new JButton("Button 3"));

        /*
         * Adjusts the windows size, centers it in screen and makes it visible.
         */
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        /*
         * Creates a new instance of GridLayoutDemo. Try to resize the window
         * and see the results.
         */
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GridLayoutDemo();
            }

        });

    }
}