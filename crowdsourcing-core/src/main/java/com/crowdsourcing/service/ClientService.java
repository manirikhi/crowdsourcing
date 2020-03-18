package com.crowdsourcing.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.User;

public interface ClientService {
	
	public Boolean signUp(Client client) throws CoreException;
	public String signIn(String email,String password) throws CoreException;	
	public List<Client> getClients() throws CoreException;
	public Client getById(final String id) throws CoreException;	
	public Boolean updateClient(Client client) throws CoreException;
	public Boolean createTask(Task task) throws CoreException;		
	
}
