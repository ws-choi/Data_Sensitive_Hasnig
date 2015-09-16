package point.data;

import point.Point;

public class Data extends Point{

	final static StringBuffer out = new StringBuffer();
	
	public Data(int dim, double[] vector) {
		super(dim, vector);
	}
	
	public Data(int dim)
	{
		super(dim);
		vector = new double[dimension];
	}
	
	public String toString(){
		
		out.delete(0, out.length());
		out.append(vector[0]);
		
		
		for (int i = 1; i < vector.length; i++)
			out.append(", "+ vector[i]);
		
		
		return out.toString();
		
	}
	
}
