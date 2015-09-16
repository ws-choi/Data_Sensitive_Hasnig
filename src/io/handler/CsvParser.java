package io.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import point.data.Data;

public class CsvParser {
	
	File inputFile;
	BufferedReader reader;
	int dim;
	
	public CsvParser( String path ) throws NumberFormatException, IOException {
		
		inputFile = new File(path);
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			dim = Integer.parseInt(reader.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Cannot find File.");
		}
		
	}
	
	public Data getNext() {
		
		String buf;
		try {
		
			buf = reader.readLine();
			if(buf==null) return null;
	
		} catch (IOException e) {
			
			System.err.println("file input error");
			e.printStackTrace();
			return null;
		}

		String[] vectors;
		vectors = buf.split(",");
		
		Data data = new Data(dim);
		
		for (int i = 0; i < vectors.length; i++) 
			data.vector[i] = Double.parseDouble(vectors[i]);
		
		return data;
		
	}
	
/*	public static void main(String[] args) throws NumberFormatException, IOException {
		
		CsvParser parser = new CsvParser("D:/Dropbox/0. WorkSpace/1. 공부/2015학년도 1학기 지식정보베이스 [정재화]/0. 발표 준비/DSH_ Data Sensitive Hashing for High-Dimensional k-NN/실험/normal.csv");
		Data data;
		while((data = parser.getNext()) != null)
			System.out.println(data);
	}*/

}
