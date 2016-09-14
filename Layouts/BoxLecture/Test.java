import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame{

	public Test() {
		super("CSCI 201 Window");
		setSize(200, 220);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp= new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

		JButton button1 = new JButton("Button 1");
		jp.add(button1);
		jp.add(Box.createGlue());
		JButton button2 = new JButton("Button 2");
		jp.add(button2);
		JButton button3 = new JButton("Button 3");
		jp.add(button3);

		add(jp);
		setVisible(true);
	}

	public static void main(String [] args) {
		Test t = new Test();
	}
}
