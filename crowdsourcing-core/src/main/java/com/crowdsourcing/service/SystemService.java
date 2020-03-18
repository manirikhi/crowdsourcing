package com.crowdsourcing.service;

import java.util.List;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.Worker;

public interface SystemService {
		
	public List<Worker> getPotentialWorkers(Task task) throws CoreException;	
		
}
