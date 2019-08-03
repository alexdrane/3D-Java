import java.awt.Color;
import java.awt.Graphics;

public class Plane {
	Vector[] vectList;
	
	public Plane(Vector[] vList) {
		vectList = vList;
	}
	
	public void render(Graphics g, ViewPoint Vpt, double ang) {
		int[] xList = new int[vectList.length];
		int[] yList = new int[vectList.length];
		boolean d = true;
		Vector[] vects = new Vector[vectList.length];
		
		for (var i = 0; i < vectList.length; i++) {
			Vector newV = vectList[i].subtract(Vpt.viewPoint);
			vects[i] = newV.rotateZ(-ang);
		}
		
		for (var i =0 ; i < vects.length; i++) {
			Vector v = vects[i];
			double scale = v.y/Vpt.yOffset;
			if (scale <= 0) {
				d = false;
			}
			int tX = (int)(600+v.x/scale);
			int tY = (int)(300-v.z/scale);
			xList[i] = tX;
			yList[i] = tY;
		}
		Vector normal = vects[1].subtract(vects[0]).cross(vects[vects.length-1].subtract(vects[0]));
		Vector n = vects[0];
		double dot = n.dot(normal);
		if (d && dot > 0) {
			draw(g,xList,yList);
		}
	}
	
	public void draw(Graphics g, int[] xArray, int[] yArray) {
		g.setColor(Color.gray);
		g.fillPolygon(xArray, yArray, xArray.length);
		g.setColor(Color.black);
		g.drawPolygon(xArray, yArray, xArray.length);
	}
	
	public double distance(ViewPoint Vpt) {
		double tot = 0;
		for (var i = 0; i < vectList.length; i++) {
			tot+=vectList[i].subtract(Vpt.viewPoint).magnitude();
		}
		return tot/vectList.length;
	}
	
	public Plane add(Vector a) {
		Vector[] newVects = new Vector[vectList.length];
		for (var i = 0; i < vectList.length; i++) {
			newVects[i] = vectList[i].add(a);
		}
		return new Plane(newVects);
	}
}
