import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6811176597278658065L;
	
	double x = 200, y = 200;
	static int W = 1200, H = 600;
	static Plane p;
	static ViewPoint Vpt;
	
	public Screen() {
		setSize(new Dimension(W,H));
		setPreferredSize(new Dimension(W,H));
	}
	
	public static void main(String[] args) {
		Screen screen = new Screen();
		
		JFrame frame = new JFrame("My Drawing");
		frame.add(screen);
		frame.pack();
    	frame.setVisible(true);
    	Vector[] vList = new Vector[] {new Vector(-200, 1200, 0), new Vector(300, 1400, 100), new Vector(0, 1000, 500)};
    	p = new Plane(vList);
    	Vpt = new ViewPoint(new Vector(0,0,0),W,H,800);
	};
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, W, H);
		p.render(g, Vpt);
		Vpt.move(new Vector(1,0,0));
		repaint();
	}
}
