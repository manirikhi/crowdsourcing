package com.crowdsourcing.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.crowdsourcing.dao.WorkerDAO;
import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.Worker;

@Service("systemService")
public class SystemServiceImpl implements SystemService{	
	
	@Autowired
	private WorkerDAO workerDAO;	

	@Override
	public List<Worker> getPotentialWorkers(Task task) throws CoreException{
	
	   String taskLocation = task.getTaskLocation();
	   String requiredSkills = task.getRequiredSkills();
	   Double requiredCredibility = task.getRequiredCredibiliy();	   	  
	   
	   Query searchUserQuery = new Query(Criteria.where("workerLocation").regex( Pattern.compile(taskLocation, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
	   searchUserQuery.addCriteria(Criteria.where("workCredibility").gte(requiredCredibility));	  
	   for(String requiredSkill:requiredSkills.split(",")){
		   searchUserQuery.addCriteria(Criteria.where("skills").regex( Pattern.compile(".*"+requiredSkill+".*", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
	   }	   
		
		return workerDAO.find(searchUserQuery);
	}
		

}
