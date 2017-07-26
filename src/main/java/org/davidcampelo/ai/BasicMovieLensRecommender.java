package org.davidcampelo.ai;

import java.io.IOException;


import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.davidcampelo.ai.rs.SimpleDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicMovieLensRecommender 
{
	private static Logger logger = LoggerFactory.getLogger(BasicMovieLensRecommender.class); 
    public static void main( String[] args ) throws IOException, TasteException
    {
    	logger.info("**** Creating Item Based Recommender...");
    	// mahout data model
    	DataModel dataModel = SimpleDataModel.createMovieLensModel();
    	// similarity function
    	TanimotoCoefficientSimilarity coefficientSimilarity = new TanimotoCoefficientSimilarity(dataModel);
    	// recommender
    	GenericItemBasedRecommender basedRecommender = new GenericItemBasedRecommender(dataModel, coefficientSimilarity);
    	// do it!
    	logger.info("**** Showing the most similar itens of 10 items...");
    	int count = 0;
    	for (LongPrimitiveIterator it = dataModel.getItemIDs(); it.hasNext() && count++ < 10; ) {
    		long itemID = it.nextLong();
    		for (RecommendedItem item : basedRecommender.mostSimilarItems(itemID, 10) ) {
    			logger.info("ITEM ID = " + itemID + "\tMOST SIMILAR ITEM ID = " +item.getItemID() + "\t" + "SIMILARITY VALUE = "+ item.getValue());
			}
    	}
        
    }
}
