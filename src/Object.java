import java.awt.Graphics;
import java.util.Arrays;

public class Object {
	Plane[] planes;
	
	public Object(Construct c, Vector centre) {
		Plane[] newPlanes = new Plane[c.planes.length];
		for (var i = 0; i < c.planes.length; i++) {
			newPlanes[i] = (c.planes[i].add(centre));
		}
		planes = newPlanes;
	}
	
	public void render(Graphics g, ViewPoint Vpt, double ang) {
		//System.out.println(planes.length);
		double[] magnitudes = new double[planes.length];
		for (var i = 0; i < planes.length; i++) {
			magnitudes[i] = planes[i].distance(Vpt);
			//System.out.println(magnitudes[i]);
		}
	
		int[] indexes = Sorter.sortMax(magnitudes);
		for (var i = 0; i < planes.length; i++) {
			planes[indexes[i]].render(g, Vpt, ang);
		}
	}
	
	public double distance(ViewPoint Vpt) {
		double tot = 0;
		for (var i = 0; i < planes.length; i++) {
			tot+=planes[i].distance(Vpt);
		}
		return tot/planes.length;
	}

}
