
public class Construct {
	Plane[] planes;
	int[][] f;
	Vector[] v;
	
	public Construct(Vector[] vects, int[][] faces) {
		f = faces;
		v = vects;
		planes = new Plane[faces.length];
		for (var i = 0; i < faces.length; i++) {
			//System.out.println(i);
			Vector[] newVects = new Vector[faces[i].length];
			for (var j = 0; j < faces[i].length; j++) {
				newVects[j] = vects[faces[i][j]-1];
			}
			planes[i] = new Plane(newVects);
		}
	}
		
	public Construct getScaled(double s) {
		Vector[] newVects= new Vector[v.length];
		for (var i = 0 ; i < v.length; i++) {
			newVects[i] = v[i].scalar(s);
		}
		return new Construct(newVects,f);
	}

}
