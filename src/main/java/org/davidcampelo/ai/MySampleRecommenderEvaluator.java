package org.davidcampelo.ai;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;
import org.davidcampelo.ai.rs.SimpleDataModel;
import org.davidcampelo.ai.rs.SimpleRecommenderBuilder;

public class MySampleRecommenderEvaluator {
	public static void main(String[] args) throws IOException {
		
		RandomUtils.useTestSeed();
		
        
        RecommenderEvaluator recommenderEvaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();

        DataModel dataModel = SimpleDataModel.createSampleModel(); 
		
        double error = -1;
		try {
			error = recommenderEvaluator.evaluate(new SimpleRecommenderBuilder(), null, dataModel, 0.9, 1.0);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(error);
	}

}
