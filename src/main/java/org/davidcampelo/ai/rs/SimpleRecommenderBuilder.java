package org.davidcampelo.ai.rs;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class SimpleRecommenderBuilder implements RecommenderBuilder {

	public Recommender buildRecommender(DataModel dataModel) throws TasteException {
        // Similarity function
        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        
        ThresholdUserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, dataModel);
        
        UserBasedRecommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
        
		return recommender;
	}

}
