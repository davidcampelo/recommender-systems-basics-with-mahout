package org.davidcampelo.ai.rs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

public class SimpleDataModel {

	private static String PATH = "src/main/resources/";

	private static DataModel createModel(String filePath) throws IOException {
		// Data model
		File file = new File(filePath);
		DataModel dataModel = new FileDataModel(file);

		return dataModel;		
	}

	public static DataModel createSampleModel() throws IOException {
		return createModel(PATH + "data.csv");
	}

	public static DataModel createAluraCoursesModel() throws IOException {
		return createModel(PATH + "cursos.csv");
	}

	public static DataModel createMovieLensModel() throws IOException {
		try {
			return createModel(PATH + "movielens.csv");
		}
		catch(IOException ex) {
			System.out.println("Error while creating MovieLens DataModel. Let's try to create the CSV...");
			System.out.println(ex);
			createMovieLensFile();
			
			return createModel(PATH + "movielens.csv");
		}
		
	}

	private static void createMovieLensFile() throws IOException {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(new File(PATH + "ml-100k/u.data")));
			bufferedWriter = new BufferedWriter(new FileWriter(PATH + "movielens.csv"));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] values = line.split("\\t", -1);	
				bufferedWriter.write(values[0] + "," + values[1] + "," + values[2] + "\n");
			}
		}
		catch (IOException ex) {
			System.out.println(ex);
		}
		finally {
			if (bufferedReader != null) 
				bufferedReader.close();
			if (bufferedWriter != null)
				bufferedWriter.close();
			}
	}

}
