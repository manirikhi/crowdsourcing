package com.crowdsourcing.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.crowdsourcing.dao.WorkerDAO;
import com.crowdsourcing.dao.TaskDAO;
import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.Worker;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerDAO workerDAO;
	@Autowired
	private TaskDAO taskDAO;

	@Override
	public Boolean updateWroker(Worker worker) throws CoreException {

		if (worker == null || (worker != null && worker.getWorkerId() == null)) {
			return false;
		}

		return workerDAO.create(worker);
	}

	@Override
	public Worker getWorkerDetails(String workerId) throws CoreException {
		return workerDAO.getById(workerId);
	}
	
	@Override
	public Boolean signUp(Worker worker) throws CoreException {
		return workerDAO.create(worker);
	}

	@Override
	public String signIn(String email, String password) throws CoreException {

		String workerId = "";
		Query searchUserQuery = new Query(Criteria.where("details.email").is(email));
		searchUserQuery.addCriteria(Criteria.where("details.password").is(password));

		List<Worker> workers = workerDAO.find(searchUserQuery);
		if (!CollectionUtils.isEmpty(workers)) {
			workerId = workers.get(0).getWorkerId();
		}

		return workerId;
	}


	@Override
	public List<Worker> getAllWorkers() throws CoreException {
		return workerDAO.getAll();
	}

	@Override
	public Worker getById(String id) throws CoreException {
		return workerDAO.getById(id);
	}

	@Override
	public List<Task> getAvailableTasks(String workerId) throws CoreException {

		List<Task> availableTasks = new ArrayList<>();
		List<Task> availableTasksWithSkill = new ArrayList<>();
		Worker worker = getById(workerId);
		if (worker != null) {
			String workerLocation = worker.getWorkerLocation();
			String workerSkills = worker.getSkills();
			Double workerCredibility = worker.getWorkCredibility();
			Query searchTaskQuery = new Query(Criteria.where("taskLocation")
					.regex(Pattern.compile(workerLocation, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
			searchTaskQuery.addCriteria(Criteria.where("requiredCredibiliy").gte(workerCredibility));											
			searchTaskQuery.addCriteria(Criteria.where("taskAssigned").is(false));
			availableTasks = taskDAO.find(searchTaskQuery);
			//remove rejected tasks
			List<String> rejectedTaskIds = worker.getRejectedTaskIds();
			Iterator<Task> availableTaskIterator = availableTasks.iterator();
			if(!CollectionUtils.isEmpty(rejectedTaskIds)){
				while(availableTaskIterator.hasNext()){
					Task availableTask =availableTaskIterator.next();
					if(rejectedTaskIds.contains(availableTask.getTaskId())){
						availableTaskIterator.remove();
					}
				}	
			}								
								
			for(Task availableTask:availableTasks){						
				for(String workerSkill : workerSkills.split(",")){					
					if(availableTask.getRequiredSkills().toUpperCase().contains(workerSkill.toUpperCase())){
						availableTasksWithSkill.add(availableTask);
						break;
					}	
				}
				
			}
		}

		return availableTasksWithSkill;
	}

}
