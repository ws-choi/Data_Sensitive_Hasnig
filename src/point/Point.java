package point;


public class Point {
	
	public int dimension;
	public double[] vector;
	
	public Point(int dim, double[] vector) {

		if(vector.length != dim)
			try {
				throw new Exception();
			} catch (Exception e) {
				System.err.println("Dimension error. please check dimension");
				e.printStackTrace();
			}
		this.dimension = dim;
		this.vector=vector.clone();
	}

	public Point(int dim) {
		this.dimension = dim;
	}
	
	

}
