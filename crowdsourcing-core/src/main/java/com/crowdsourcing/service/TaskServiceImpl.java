package com.crowdsourcing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.crowdsourcing.dao.ClientDAO;
import com.crowdsourcing.dao.TaskDAO;
import com.crowdsourcing.dao.WorkerDAO;
import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.Worker;

@Service("taskService")
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDAO taskDAO;
	@Autowired
	private ClientDAO clientDAO;
	@Autowired
	private WorkerDAO workerDAO;
	
	@Override
	public List<Task> getAllTasks() throws CoreException {		
		return taskDAO.getAll();
	}

	@Override
	public Boolean createTask(Task task) throws CoreException {
		return taskDAO.create(task);
	}
	
	@Override
	public Boolean acceptTask(String taskId, String workerId) throws CoreException {

		Task task = taskDAO.getById(taskId);
		task.setTaskAssigned(true);
		taskDAO.create(task);

		Worker worker = workerDAO.getById(workerId);
		if(worker.getTaskIds()!=null){
			worker.getTaskIds().add(task.getTaskId());	
		}
		else{
			List<String> taskIds = new ArrayList<>();
			taskIds.add(task.getTaskId());
			worker.setTaskIds(taskIds);
		}
		
		return workerDAO.create(worker);

	}
	
	@Override
	public Boolean rejectTask(String taskId, String workerId) throws CoreException {
		
		Worker worker = workerDAO.getById(workerId);
		List<String> taskIds = worker.getRejectedTaskIds();
		if(taskIds!=null){
			worker.getRejectedTaskIds().add(taskId);	
		}
		else{
			taskIds = new ArrayList<>();
			taskIds.add(taskId);
			worker.setRejectedTaskIds(taskIds);
		}
		
		return workerDAO.create(worker);
	}

	
	@Override
	public List<Task> getTasksPerUser(String userId) throws CoreException {
		
		Client client = clientDAO.getById(userId);
		List<String> taskIds = new ArrayList<>();		
		if(client!=null){
			taskIds = client.getTaskIds();	
		}
		else{
			Worker worker = workerDAO.getById(userId);
			if(worker!=null){
				taskIds = worker.getTaskIds();	
			}			
		}
		
		if(!CollectionUtils.isEmpty(taskIds)){
			Query query = new Query(Criteria.where("taskId").in(taskIds));									
			return taskDAO.find(query);
		}
		else{
		 return new ArrayList<>();	
		}
											   
	}
	
	@Override
	public Boolean markTaskCompleted(String taskId, String workerId) throws CoreException {

		Worker worker = workerDAO.getById(workerId);
		List<String> taskIds = worker.getTaskIds();
		for (String task : taskIds) {
			if (task.equals(taskId)) {
				Task existingTask = taskDAO.getById(taskId);
				existingTask.setTaskCompleted(true);
				taskDAO.create(existingTask);
				break;
			}
		}
		// increment worker experience
		worker.setWorkExperience(worker.getWorkExperience() + 1);
		return workerDAO.create(worker);
	}
	
	@Override
	public Boolean submitRatings(Double rating, String taskId) throws CoreException{					
		Task task = taskDAO.getById(taskId);
		task.setTaskRating(rating);		
		
		taskDAO.create(task);		
		
		//find worker associated with task		
		
		//update credibility of worker
		Query query = new Query(Criteria.where("taskIds").in(taskId));
		if(!CollectionUtils.isEmpty(workerDAO.find(query))){
			Worker worker = workerDAO.find(query).get(0);			
			double credibilityAvg = rating;
			if(worker.getWorkCredibility()!=null){
				credibilityAvg = (worker.getWorkCredibility()+rating)/2;
			}		
			worker.setWorkCredibility(credibilityAvg);
			
			return workerDAO.create(worker);
		}
				
		return true;
	}

}
