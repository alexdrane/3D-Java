import java.awt.Graphics;

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
		for (var i = 0; i < planes.length; i++) {
			planes[i].render(g, Vpt , ang);
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
