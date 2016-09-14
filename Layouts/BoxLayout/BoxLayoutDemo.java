import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoxLayoutDemo {
    private int alignment;
    private ComponentOrientation orientation;

    private static final String X_AXIS = "X_AXIS";
    private static final String Y_AXIS = "Y_AXIS";
    private static final String LINE_AXIS = "LINE_AXIS";
    private static final String PAGE_AXIS = "PAGE_AXIS";

    private static final String LEFT_TO_RIGHT = "Left to Right";
    private static final String RIGHT_TO_LEFT = "Right to Left";
    private static final String DEFAULT_ORIENTATION = "Default Orientation";

    private ActionListener alignmentListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (X_AXIS.equals(e.getActionCommand())) {
                alignment = BoxLayout.X_AXIS;
            } else if (Y_AXIS.equals(e.getActionCommand())) {
                alignment = BoxLayout.Y_AXIS;
            } else if (LINE_AXIS.equals(e.getActionCommand())) {
                alignment = BoxLayout.LINE_AXIS;
            } else if (PAGE_AXIS.equals(e.getActionCommand())) {
                alignment = BoxLayout.PAGE_AXIS;
            } else if (LEFT_TO_RIGHT.equals(e.getActionCommand())){
                orientation = ComponentOrientation.LEFT_TO_RIGHT;
            } else if (RIGHT_TO_LEFT.equals(e.getActionCommand())){
                orientation = ComponentOrientation.RIGHT_TO_LEFT;
            } else if (DEFAULT_ORIENTATION.equals(e.getActionCommand())){
                orientation = null;
            }
        }
    };

    public JFrame buildMainFrame(){
        JFrame boxLayoutDemoFrame = new JFrame("BoxLayoutFrame");
        boxLayoutDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = boxLayoutDemoFrame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        ButtonGroup alignmentGroup = new ButtonGroup();

        JRadioButton xAxisButton = buildAlignmentButton(alignmentGroup, X_AXIS);
        xAxisButton.setSelected(true);
        JRadioButton yAxisButton = buildAlignmentButton(alignmentGroup, Y_AXIS);
        JRadioButton lineAxisButton = buildAlignmentButton(alignmentGroup, LINE_AXIS);
        JRadioButton pageAxisButton = buildAlignmentButton(alignmentGroup, PAGE_AXIS);

        final ButtonGroup orientationGroup = new ButtonGroup();
        JRadioButton defaultOrientation = buildAlignmentButton(orientationGroup, DEFAULT_ORIENTATION);
        defaultOrientation.setSelected(true);
        JRadioButton leftToRight = buildAlignmentButton(orientationGroup, LEFT_TO_RIGHT);
        JRadioButton rightToLeft = buildAlignmentButton(orientationGroup, RIGHT_TO_LEFT);

        JButton openFrameButton = new JButton("Build window");
        openFrameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame demoFrame = new JFrame("Demo Frame");

                Container contentPane = demoFrame.getContentPane();
                contentPane.setLayout(new BoxLayout(contentPane, alignment));
                if(orientation != null){
                    contentPane.setComponentOrientation(orientation);
                }

                JButton buttonA;
                JButton buttonB;
                JButton buttonC;
                JButton buttonD;

                if(alignment == BoxLayout.PAGE_AXIS || alignment == BoxLayout.Y_AXIS){
                    buttonA = new JButton("Left Aligned");
                    buttonA.setAlignmentX(JComponent.LEFT_ALIGNMENT);
                    buttonB = new JButton("Right Aligned");
                    buttonB.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
                    buttonC = new JButton("Center Aligned");
                    buttonC.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                    buttonD = new JButton("Default Aligned");
                } else {
                    buttonA = new JButton("Top Aligned");
                    buttonA.setAlignmentY(Component.TOP_ALIGNMENT);
                    buttonB = new JButton("Bottom Aligned");
                    buttonB.setAlignmentY(Component.BOTTOM_ALIGNMENT);
                    buttonC = new JButton("Center Aligned");
                    buttonC.setAlignmentY(Component.CENTER_ALIGNMENT);
                    buttonD = new JButton("Default Aligned");
                }

                contentPane.add(buttonA);
                contentPane.add(buttonB);
                contentPane.add(buttonC);
                contentPane.add(buttonD);

                demoFrame.pack();
                demoFrame.setVisible(true);
            }
        });

        contentPane.add(new JLabel("Alignment Options"));
        contentPane.add(xAxisButton);
        contentPane.add(yAxisButton);
        contentPane.add(lineAxisButton);
        contentPane.add(pageAxisButton);

        contentPane.add(new JSeparator());
        contentPane.add(new JLabel("Orientation"));
        contentPane.add(defaultOrientation);
        contentPane.add(leftToRight);
        contentPane.add(rightToLeft);

        contentPane.add(new JSeparator());
        contentPane.add(openFrameButton);
        boxLayoutDemoFrame.setSize(250, 300);

        return boxLayoutDemoFrame;
    }

    private JRadioButton buildAlignmentButton(ButtonGroup alignmentGroup, String alignmentName) {
        JRadioButton xAxisButton = new JRadioButton(alignmentName, false);
        xAxisButton.setActionCommand(alignmentName);
        xAxisButton.addActionListener(alignmentListener);
        alignmentGroup.add(xAxisButton);
        return xAxisButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BoxLayoutDemo demo = new BoxLayoutDemo();
                JFrame boxLayoutDemoFrame = demo.buildMainFrame();
                boxLayoutDemoFrame.setVisible(true);
            }
        });
    }
}