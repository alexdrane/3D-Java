import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener, MouseMotionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6811176597278658065L;
	
	double x = 200, y = 200;
	static int W = 1200, H = 600;
	static Environment world;
	static ViewPoint Vpt;
	double xv = 0, yv = 0, zv = 0;
	static int px;
	static int py;
	
	public Screen() {
		setSize(new Dimension(W,H));
		setPreferredSize(new Dimension(W,H));
		addKeyListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
	}
	
	public static void main(String[] args) {
		px = MouseInfo.getPointerInfo().getLocation().x;
		py = MouseInfo.getPointerInfo().getLocation().y;
		
		Screen screen = new Screen();
		
		
		Construct cube = new Construct(
    			new Vector[] {
    					new Vector(-200,200,-200),
    					new Vector(200,200,-200),
    					new Vector(200,-200,-200),
    					new Vector(-200,-200,-200),
    					new Vector(-200,200,200),
    					new Vector(200,200,200),
    					new Vector(200,-200,200),
    					new Vector(-200,-200,200)
    			},
    			new int[][] {
    				new int[] {4,3,2,1},
    				new int[] {5,6,7,8},
    				new int[] {1,2,6,5},
    				new int[] {2,3,7,6},
    				new int[] {3,4,8,7},
    				new int[] {4,1,5,8},
    			}
    			).getScaled(0.5);
		Vpt = new ViewPoint(new Vector(0,0,0),W,H,1000);
    	world = new Environment(new Object[] {new Object(cube,new Vector(2000,4000,0)),
    			new Object(cube,new Vector(200,2200,0)),
    			new Object(cube,new Vector(-200,1800,0)),
    			new Object(cube,new Vector(-600,2800,0)),
    			new Object(cube,new Vector(600,2400,0))},
    			Vpt);
    	
		
		JFrame frame = new JFrame("My Drawing");
		frame.add(screen);
		frame.pack();
    	frame.setVisible(true);
	};
	
	public void paint(Graphics g) {
		
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		
		
		
		g.clearRect(0, 0, W, H);
		world.render(g);
		world.move(xv*2,yv*2,zv*2);
		world.rotateZ((-x+px));
		repaint();
		
		px = x;
		py = y;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W && yv < 1){
	        yv += 1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_S && yv > -1){
	        yv-=1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_A && xv > -1){
	        xv -= 1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_D && xv < 1){
	        xv+=1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_SPACE && zv < 1){
	        zv += 1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_SHIFT && zv > -1){
	        zv-=1;
	    }

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
	        yv -= 1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_S){
	        yv+=1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_A){
	        xv += 1;
	    }
	    if(e.getKeyCode() == KeyEvent.VK_D){
	        xv-=1;
	    }
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}


}
