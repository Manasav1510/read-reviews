package com.read.reviews.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.read.reviews.entity.CustomSequences;


@Service
public class NextSequenceService {
	
	@Autowired
	private MongoOperations mongo;
	
	
	public int getNextSequence(String seqName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(seqName));
		Update update = new Update().inc("seq",1);
		CustomSequences counter = mongo.findAndModify(query,update,CustomSequences.class);
		return counter.getSeq();
	}

}
