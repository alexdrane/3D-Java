import java.awt.Graphics;
import java.util.Arrays;

public class Environment {
	Object[] objects;
	double ang = 0;
	ViewPoint Vpt;
	
	public Environment(Object[] objs, ViewPoint V) {
		objects = objs;
		Vpt = V;
	}
	
	public void render(Graphics g) {
		double[] magnitudes = new double[objects.length];
		for (var i =0; i<objects.length; i++) {
			magnitudes[i] = objects[i].distance(Vpt);
		}
		
		int[] indexes = Sorter.sortMax(magnitudes);
		
		for (var i = 0; i < indexes.length; i++) {
			objects[indexes[i]].render(g, Vpt, ang);
		}
		
	}
	public void rotateZ(double a) {
		ang += a;
	}
	
	public void move(double x, double y, double z) {
		Vector v = new Vector(x,y,z).rotateZ(ang);
		Vpt.move(v);
	}

}
