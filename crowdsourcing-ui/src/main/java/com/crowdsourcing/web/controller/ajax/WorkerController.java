package com.crowdsourcing.web.controller.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.User;
import com.crowdsourcing.model.Worker;
import com.crowdsourcing.service.WorkerService;


@RestController
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@RequestMapping(value="/workers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Worker>> getWorkers() throws CoreException {
		System.out.println("Hello");		
		return new ResponseEntity<List<Worker>>(workerService.getAllWorkers(), HttpStatus.OK);
	}	
	
	@RequestMapping(value="/worker", method = RequestMethod.GET)	
	public ResponseEntity<Worker> getClientById(@RequestParam("workerId") String workerId) throws CoreException {		
		return new ResponseEntity<Worker>(workerService.getById(workerId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/worker/tasks", method = RequestMethod.GET)	
	public ResponseEntity<List<Task>> getTasksForWorker(@RequestParam("workerId") String workerId) throws CoreException {		
		return new ResponseEntity<List<Task>>(workerService.getAvailableTasks(workerId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/worker/create", method = RequestMethod.POST)	
	public ResponseEntity<Boolean> createTask(@RequestBody Worker worker) throws CoreException {		
		return new ResponseEntity<Boolean>(workerService.signUp(worker), HttpStatus.CREATED);
	}
	
}
