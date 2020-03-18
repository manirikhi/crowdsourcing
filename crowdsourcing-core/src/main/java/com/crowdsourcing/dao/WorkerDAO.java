package com.crowdsourcing.dao;

import org.springframework.stereotype.Repository;

import com.crowdsourcing.model.Worker;

@Repository
public class WorkerDAO extends AbstractDAO<Worker>{
	
	public WorkerDAO() {
		super(Worker.class);
	}	

}
