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
		
		int[] forbiden = new int[objects.length];
		for (var j = 0; j < objects.length; j++) {
			double cur = magnitudes[0];
			int curPos = 0;
			for (var l =0; l<magnitudes.length; l++) {
				int c = l;
				if (!Arrays.stream(forbiden).anyMatch(i -> i == c) && (magnitudes[l] > cur||j == objects.length-1)) {
					cur = magnitudes[l];
					curPos = l;
				}
			}
			forbiden[j] = curPos;
			objects[curPos].render(g, Vpt , ang);
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
