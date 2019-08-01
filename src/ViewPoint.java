
public class ViewPoint {
	Vector viewPoint;
	int W, H;
	double yOffset;
	
	public ViewPoint(Vector pos, int nW, int nH, double y) {
		viewPoint = pos;
		W = nW;
		H = nH;
		yOffset = y;
	}
	
	public double getFrameY() {
		return viewPoint.y+yOffset;
	}
	
	public void move(Vector moveVect) {
		viewPoint = viewPoint.add(moveVect);
	}

}
