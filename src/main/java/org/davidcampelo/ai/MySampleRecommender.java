package org.davidcampelo.ai;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.davidcampelo.ai.rs.SimpleDataModel;
import org.davidcampelo.ai.rs.SimpleRecommenderBuilder;

/**
 * Hello world!
 *
 */
public class MySampleRecommender 
{
    public static void main( String[] args ) throws IOException, TasteException
    {
        DataModel dataModel = SimpleDataModel.createSampleModel();
        Recommender recommender = new SimpleRecommenderBuilder().buildRecommender(dataModel);

        List<RecommendedItem> list = recommender.recommend(2, 3);
        for (RecommendedItem item : list) {
        	System.out.println(item);
			
		}
    }
}
