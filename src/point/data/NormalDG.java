package point.data;


public class NormalDG extends DataGenerator{

	double[] means, vars;
	
	public NormalDG(int dim, double[][] bounds)
			throws Exception {		

		super(dim, bounds);
		
		UniformDG udg= new UniformDG(dim, bounds);

		means = new double[dim];
		vars = new double[dim];
		
		for (int i = 0; i < means.length; i++) {
			means[i] = udg.sample_RV(i);
			vars[i] = 10;
		}
	}

	@Override
	double sample_RV(int dim) {
		
		double nr01;
		double result;
		
		if(bounds[dim][0] == bounds[dim][1])
			return bounds[dim][0];
		
		do{
			nr01 = (float)normalRandom();
			result = nr01 * vars[dim] + means[dim];
			
		}while(!validate(dim, result));
		
		return result;
	}

	private boolean validate(int dim, double res) {
		
		if(res>= bounds[dim][0])
			if(res <= bounds[dim][1])
				return true;
		
		return false;
	}

	private double normalRandom () {
		return Math.sqrt( -2.0d * Math.log( Math.random() ) ) * 
				Math.sin( 2.0d * Math.PI * Math.random() );

	}
}
