package com.crowdsourcing.dao;

import org.springframework.stereotype.Repository;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;

@Repository
public class ClientDAO extends AbstractDAO<Client>{

	public ClientDAO() {
		super(Client.class);
	}	
	
	/*public boolean findByEmail(){
		
	}*/
}
