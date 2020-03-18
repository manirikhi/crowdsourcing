package com.crowdsourcing.service;


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
import com.crowdsourcing.model.User;
import com.crowdsourcing.model.Worker;

@Service("clientService")
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientDAO clientDAO;
	@Autowired
	private TaskDAO taskDAO;	
	@Autowired
	private WorkerDAO workerDAO;	

	@Override
	public Boolean updateClient(Client client) throws CoreException{
		
		if(client == null || (client!=null && client.getClientId() == null)){
			return false;
		}
		
		return clientDAO.create(client);							
	}

	@Override
	public Boolean createTask(Task task) throws CoreException {
		
	   taskDAO.create(task);
	   Client client = clientDAO.getById(task.getClientId());
	   client.getTaskIds().add(task.getTaskId());
	   	   
	   return clientDAO.create(client);		   
	}
	
	
	@Override
	public Boolean signUp(Client client) throws CoreException {		
		return clientDAO.create(client);
	}

	@Override
	public String signIn(String email,String password) throws CoreException {
		
		String clientId = "";
		Query searchUserQuery = new Query(Criteria.where("details.email").is(email));		
		      searchUserQuery.addCriteria(Criteria.where("details.password").is(password));		   

		List<Client> clients = clientDAO.find(searchUserQuery);
		if(!CollectionUtils.isEmpty(clients)){
			clientId = clients.get(0).getClientId();
		}
			    	    	
	    return clientId;
	}

	@Override
	public Client getById(String id) throws CoreException {		
		return clientDAO.getById(id);
	}

	@Override
	public List<Client> getClients() throws CoreException {

		return clientDAO.getAll();
	}
	
}
