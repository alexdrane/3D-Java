import java.awt.Graphics;

public class Plane {
	Vector[] vectList;
	
	public Plane(Vector[] vList) {
		vectList = vList;
	}
	
	public void render(Graphics g, ViewPoint Vpt) {
		int[] xList = new int[vectList.length];
		int[] yList = new int[vectList.length];
		for (var i =0 ; i < vectList.length; i++) {
			Vector v = vectList[i].subtract(Vpt.viewPoint);
			double scale = v.subtract(Vpt.viewPoint).y/Vpt.yOffset;
			int tX = (int)(600+v.x/scale);
			int tY = (int)(600-v.z/scale);
			xList[i] = tX;
			yList[i] = tY;
		}
		draw(g,xList,yList);
	}
	
	public void draw(Graphics g, int[] xArray, int[] yArray) {
		g.fillPolygon(xArray, yArray, xArray.length);
	}
}
