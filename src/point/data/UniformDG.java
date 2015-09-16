package point.data;



public class UniformDG extends DataGenerator{

	public UniformDG (int dim, double[][] bounds) throws Exception {
		super(dim, bounds);
	}
	


	@Override
	double sample_RV(int dim) {

		double min = bounds[dim][0];
		double max = bounds[dim][1];
		
		return (Math.random() * (max-min) + min);
	}

}
