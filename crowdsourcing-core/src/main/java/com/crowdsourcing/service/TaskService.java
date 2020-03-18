package com.crowdsourcing.service;

import java.util.List;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Task;

public interface TaskService {

	public List<Task> getAllTasks() throws CoreException;
	
	public Boolean createTask(Task task) throws CoreException;
	
	public List<Task> getTasksPerUser(String userId) throws CoreException;
	
	public Boolean acceptTask(String taskId,String workerId) throws CoreException;
	
	public Boolean rejectTask(String taskId,String workerId) throws CoreException;
	
	public Boolean markTaskCompleted(String taskId,String workerId) throws CoreException;

	public Boolean submitRatings(Double rating,String taskId) throws CoreException;
}
