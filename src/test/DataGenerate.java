package test;

import point.data.DataGenerator;
import point.data.NormalDG;
import point.data.UniformDG;

public class DataGenerate {

	public static void main(String[] args) throws Exception {
		
		double[][] bounds = { {0,100}, {0, 100} };
		DataGenerator dg = new NormalDG(2, bounds);
		
		for (int i = 0; i < 100; i++) {
			System.out.println(dg.getNext());
		}
		
	}
}
