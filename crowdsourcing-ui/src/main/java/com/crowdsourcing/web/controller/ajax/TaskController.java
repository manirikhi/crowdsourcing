package com.crowdsourcing.web.controller.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.Worker;
import com.crowdsourcing.service.ClientService;
import com.crowdsourcing.service.TaskService;
import com.crowdsourcing.service.WorkerService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private ClientService clientService;	

	@RequestMapping(value="/tasks", method = RequestMethod.GET)	
	public ResponseEntity<List<Task>> getClients() throws CoreException {		
		return new ResponseEntity<List<Task>>(taskService.getAllTasks(), HttpStatus.OK);
	}
	
	//get all tasks for user
	@RequestMapping(value="/taskList", method = RequestMethod.GET)	
	public ResponseEntity<List<Task>> getTaskPerUser(@RequestParam("userId") String userId) throws CoreException {		
			return new ResponseEntity<List<Task>>(taskService.getTasksPerUser(userId), HttpStatus.OK);					
	}
	
	@RequestMapping(value="/task/create", method = RequestMethod.POST)	
	public ResponseEntity<Boolean> createTask(@RequestBody Task task) throws CoreException {								
			
		return new ResponseEntity<Boolean>(clientService.createTask(task), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/task/accept", method = RequestMethod.GET)	
	public ResponseEntity<Boolean> acceptTask(@RequestParam("taskId") String taskId,@RequestParam("workerId") String workerId) throws CoreException {								
			
		return new ResponseEntity<Boolean>(taskService.acceptTask(taskId, workerId), HttpStatus.CREATED);
	}	
	
	@RequestMapping(value="/task/reject", method = RequestMethod.GET)	
	public ResponseEntity<Boolean> rejectTask(@RequestParam("taskId") String taskId,@RequestParam("workerId") String workerId) throws CoreException {								
			
		return new ResponseEntity<Boolean>(taskService.rejectTask(taskId, workerId), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/task/completed", method = RequestMethod.GET)	
	public ResponseEntity<Boolean> markTaskCompleted(@RequestParam("taskId") String taskId,@RequestParam("workerId") String workerId) throws CoreException {								
			
		return new ResponseEntity<Boolean>(taskService.markTaskCompleted(taskId, workerId), HttpStatus.CREATED);
	}

	@RequestMapping(value="/task/rating", method = RequestMethod.GET)	
	public ResponseEntity<Boolean> submitTask(@RequestParam("rating") Double rating,@RequestParam("taskId") String taskId) throws CoreException {								
			
		return new ResponseEntity<Boolean>(taskService.submitRatings(rating, taskId), HttpStatus.CREATED);
	}
}
