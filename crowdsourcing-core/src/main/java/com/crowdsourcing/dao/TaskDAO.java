package com.crowdsourcing.dao;

import org.springframework.stereotype.Repository;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Task;

@Repository
public class TaskDAO extends AbstractDAO<Task>{

	public TaskDAO() {
		super(Task.class);
	}	
	
}
