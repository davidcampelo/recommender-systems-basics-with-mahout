package org.davidcampelo.ai;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.davidcampelo.ai.rs.SimpleDataModel;

public class BasicMovieLensRecommender 
{
	private static Logger logger = Logger.getLogger(BasicMovieLensRecommender.class); 
    public static void main( String[] args ) throws IOException, TasteException
    {
    	// log4j
    	BasicConfigurator.configure();
    	logger.info("**** Creating Item Based Recommender...");
    	// mahout data model
    	DataModel dataModel = SimpleDataModel.createMovieLensModel();
    	// similarity function
    	TanimotoCoefficientSimilarity coefficientSimilarity = new TanimotoCoefficientSimilarity(dataModel);
    	// recommender
    	GenericItemBasedRecommender basedRecommender = new GenericItemBasedRecommender(dataModel, coefficientSimilarity);
    	// do it!
    	Logger.getRootLogger().info("**** Showing the most similar itens of 10 items...");
    	int count = 0;
    	for (LongPrimitiveIterator it = dataModel.getItemIDs(); it.hasNext() && count++ < 10; ) {
    		long itemID = it.nextLong();
    		for (RecommendedItem item : basedRecommender.mostSimilarItems(itemID, 10) ) {
    			System.out.println("ITEM ID = " + itemID + "\tMOST SIMILAR ITEM ID = " +item.getItemID() + "\t" + "SIMILARITY VALUE = "+ item.getValue());
			}
    	}
        
    }
}
