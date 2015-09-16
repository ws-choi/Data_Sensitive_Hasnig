package test;

import io.handler.CsvParser;

import java.io.IOException;
import java.util.ArrayList;

import dsh.WeightMatrix;
import point.Point;
import point.data.Data;

public class MatrixTest {

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		CsvParser parser = new CsvParser("D:/Dropbox/0. WorkSpace/1. 공부/2015학년도 1학기 지식정보베이스 [정재화]/0. 발표 준비/DSH_ Data Sensitive Hashing for High-Dimensional k-NN/실험/normal 2.csv");
	
		ArrayList<Point> querySet = new ArrayList<Point>();
		ArrayList<Data> dataSet = new ArrayList<Data>();
		
		
		Data data;
		
		while((data = parser.getNext()) != null)
		{
			querySet.add(data);
			dataSet.add(data);
		}
		
		WeightMatrix wm = new WeightMatrix(2, querySet, dataSet);
		
		
	
		double[][] matrix = wm.getMatrix();
		
		
		System.out.println("?");
		System.out.println("?");
	}
}
