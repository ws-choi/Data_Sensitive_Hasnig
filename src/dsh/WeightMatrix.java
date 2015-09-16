package dsh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import point.Point;
import point.data.Data;

public class WeightMatrix {
	
	double[][] matrix;
	java.util.List<Point> querySet;
	java.util.List<Data>  dataSet;
	
	
	public WeightMatrix(int k, 	java.util.List<Point> querySet,	java.util.List<Data>  dataSet) {

		this.querySet = querySet;
		this.dataSet = dataSet;
		
		
		matrix = new double[querySet.size()][dataSet.size()];
		
		for (int i = 0; i < querySet.size(); i++) {
			
			Point query = querySet.get(i);
			ArrayList<Data> knn_for_query = nearest_objs(k, query, dataSet);
			
			for (int j = 0; j < knn_for_query.size(); j++) {
				
				int target_index = dataSet.indexOf(knn_for_query.get(j));
				matrix[i][target_index] = 1;
				
			}
			
			for (int j = 0; j < dataSet.size(); j++) 	
				if(matrix[i][j] != 1) matrix[i][j] = -1;

		}
		
		
	}
	
	private ArrayList<Data> nearest_objs ( int k, Point query, Collection<? extends Data> dataset)
	{

		final Point my_query = query;

		ArrayList<Data> sortedSet = new ArrayList<Data>(dataset);
		
		Collections.sort (sortedSet,
					
				new Comparator<Data>() {

				@Override
				public int compare(Data o1, Data o2) {
				
					double dist_1 = dist_sqr(my_query, o1);
					double dist_2 = dist_sqr(my_query, o2);
					
					if(dist_1>dist_2)
						return 1;
					
					if(dist_1<dist_2)
						return -1;
					
					else return 0;
					
				}
			}
				
		);
		
		ArrayList<Data> result = new ArrayList<Data>();
		
		for (int i = 0; i < k; i++) {
			result.add(sortedSet.remove(0));
		}
		
		return result;
	}

	private double dist_sqr (Point query, Data obj)
	{
		double dist = 0;
		int dim = query.dimension;

		double[] q_vec=query.vector;
		double[] obj_vec=obj.vector;
		
		for (int i = 0; i < dim ; i++) {
			dist += Math.pow(q_vec[i] - obj_vec[i], 2);
		}
		
		return dist;
	}
	
	
	public double[][] getMatrix()
	{
		return matrix;
	}
}
