package org.davidcampelo.ai;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * Hello world!
 *
 */
public class SimpleRecommender 
{
    public static void main( String[] args ) throws IOException, TasteException
    {
        //System.out.println( "Hello World!" );
        // Data model
        File file = new File("data.csv");
        DataModel model = new FileDataModel(file);
        // Similarity function
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        
        ThresholdUserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        
        List<RecommendedItem> list = recommender.recommend(6, 3);
        for (RecommendedItem item : list) {
        	System.out.println(item);
			
		}
    }
}
