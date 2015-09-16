package dsh;

import org.jblas.DoubleMatrix;

public class LinearAlg {

	public static double[][] Matrix_Mul (double[][] a, double[][] b)
	{
		int n=a.length;
		int m=b[0].length;
		double[][] c = new double[n][m];
        
		for (int k=0; k<m; k++) {
			for (int i=0; i<n; i++) {
				double buf = a[i][k];
				for (int j=0; j<m; j++)
					c[i][j] += buf * b[k][j];     
			}
		}
     
		return c;
	}
	
	public static DoubleMatrix Matrix_Mul2 (DoubleMatrix a, DoubleMatrix b)
	{
		int n=a.rows;
		int m=b.columns;
		double[][] c = new double[n][m];
        
		return a.mul(b);
	}
	
	public static double[][] Matrix_add (double[][] a, double[][] b)
	{

		double[][] c = new double[a.length][a[0].length];
		
		for (int j = 0; j < a[0].length; j++) 
			for (int i = 0; i < a.length; i++) 
				c[i][j] = a[i][j]+b[i][j];
			
		return c;
		
	}

	public static double[][] Matrix_sub (double[][] a, double[][] b)
	{

		double[][] c = new double[a.length][a[0].length];
		
		for (int j = 0; j < a[0].length; j++) 
			for (int i = 0; i < a.length; i++) 
				c[i][j] = a[i][j]-b[i][j];
			
		return c;
		
	}
	
	public void test()
	{
		
	}
	
	public static void main(String[] args) {
		
		
		double[][] a = {
				{1,2}
				,{3,4}
//				,{5,6}
		};
		
		
		double[][] b = {
				{2, 1},
				{5,-2}

		};
		

		DoubleMatrix aa = new DoubleMatrix(a);
		DoubleMatrix bb = new DoubleMatrix(b);
		DoubleMatrix cc = new DoubleMatrix();
		aa.mmuli(bb, cc);
		
		
		
		
		System.out.println();
	}
}
