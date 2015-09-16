package point.data;



 abstract public class DataGenerator{

	protected int dim;
	protected double bounds[][];

	public DataGenerator(int dim, double[][] bounds) throws Exception {
		this.dim = dim;
		setBounds(bounds);
	}
	
	
	private void setBounds (double[][] bounds) throws Exception {
		
		if (bounds.length != dim)	
			throw new Exception();
			
		for (int i = 0; i < bounds.length; i++)
			if(bounds[i][0] > bounds[i][1])
				throw new Exception();
		
		this.bounds = bounds.clone();
	}
	
	
	
	abstract double sample_RV(int dim); // Random Variable
	
	public Data getNext (){
	
		Data result = new Data(dim);
		
		for (int i = 0; i < dim; i++) 
			result.vector[i] = sample_RV(i);
		
		return result;
		
	}

}
