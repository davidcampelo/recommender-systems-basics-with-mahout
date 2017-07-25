package org.davidcampelo.ai.rs;

import java.io.File;
import java.io.IOException;

import org.apache.curator.framework.api.CreateModable;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

public class SimpleDataModel {

	private static String PATH = "";
	
	private static DataModel createModel(String fileName) throws IOException {
		// Data model
		File file = new File(PATH + fileName);
        DataModel dataModel = new FileDataModel(file);

        return dataModel;		
	}
	
	public static DataModel createSampleModel() throws IOException {
        return createModel("data.csv");
	}

	public static DataModel createAluraCoursesModel() throws IOException {
        return createModel("cursos.csv");
	}

}
