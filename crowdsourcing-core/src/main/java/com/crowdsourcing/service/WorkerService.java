package com.crowdsourcing.service;

import java.util.List;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.Worker;


public interface WorkerService {

	public Boolean signUp(Worker worker) throws CoreException;
	public String signIn(String email,String password) throws CoreException;	
	public List<Worker> getAllWorkers() throws CoreException;
	public Worker getById(String id) throws CoreException;
	public Boolean updateWroker(Worker worker) throws CoreException;
	public Worker getWorkerDetails(String workerId) throws CoreException;		
	public List<Task> getAvailableTasks(String workerId) throws CoreException;
}
