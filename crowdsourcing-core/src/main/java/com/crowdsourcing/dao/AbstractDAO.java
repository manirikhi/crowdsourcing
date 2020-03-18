package com.crowdsourcing.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.crowdsourcing.exception.CoreException;

public abstract class AbstractDAO<T>{
	private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
	private static final String PASSWORD_FIELD = "PASSWORD";
	private Class<T> clazz;
	protected MongoTemplate mongoTemplate;	

	public AbstractDAO(Class<T> class1) {
		this.clazz = class1;
	}
	/**
	 * @return the mongoTemplate
	 */
	public synchronized MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}


	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	@Autowired
	public synchronized void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public boolean create(T t) throws CoreException{
		mongoTemplate.save(t);
		LOGGER.info("Save the Entity in db"+t);
		return true;
	}	

	public boolean deleteById(final String id) throws CoreException{
		if(id == null)
			return false;
		Query query = new Query(new Criteria("_id").is(id));
		mongoTemplate.remove(query,clazz);
		LOGGER.info("Entity is deleted from db"+id);
		return true;
	}

	public List<T> getAll() throws CoreException{
		return mongoTemplate.findAll(clazz);
	}
	
	public T getById(final String id) throws CoreException{
		return mongoTemplate.findById(id, clazz);
	}
	
	public List<T> find(final Query query) throws CoreException{
		return mongoTemplate.find(query, clazz);
	}
}
