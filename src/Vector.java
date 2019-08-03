
public class Vector {
	double x,y,z;
	
	public Vector(double nx,double ny,double nz) {
		x = nx;
		y = ny;
		z = nz;
	}
	
	public double dot(Vector v2) {
		return x*v2.x+y*v2.y+z*v2.z;
	}
	
	public void print() {
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
	
	public Vector cross(Vector v2) {
		double nx = y*v2.z-z*v2.y;
		double ny = z*v2.x-x*v2.z;
		double nz = x*v2.y-y*v2.x;
		return new Vector(nx,ny,nz);
	}
	
	public double magnitude() {
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2));
	}
	
	public Vector add(Vector v2) {
		double nx = x+v2.x;
		double ny = y+v2.y;
		double nz = z+v2.z;
		return new Vector(nx,ny,nz);
	}
	
	public Vector subtract(Vector v2) {
		double nx = x-v2.x;
		double ny = y-v2.y;
		double nz = z-v2.z;
		return new Vector(nx,ny,nz);
	}
	
	public Vector scalar(double s) {
		double nx = x*s;
		double ny = y*s;
		double nz = z*s;
		return new Vector(nx,ny,nz);
	}
	
	public Vector rotateZ(double r) {
		double rz = (r/180)*Math.PI;
		double nx = (x*Math.cos(rz))-(y*Math.sin(rz));
		double ny = (y*Math.cos(rz))+(x*Math.sin(rz));
		double nz = z;
		return new Vector(nx,ny,nz);
	}
	
	public Vector rotateX(double rx) {
		double nx = x;
		double ny = Math.cos(rx)*y+Math.sin(rx)*y;
		double nz = -Math.sin(rx)*z+Math.cos(rx)*y;
		return new Vector(nx,ny,nz);
	}
	
	public Vector rotateY(double ry) {
		double nx = Math.cos(ry)*x-Math.sin(ry)*x;
		double ny = y;
		double nz = Math.sin(ry)*z+Math.cos(ry)*y;
		return new Vector(nx,ny,nz);
	}
	
	
}
