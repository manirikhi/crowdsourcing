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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.Client;
import com.crowdsourcing.model.Task;
import com.crowdsourcing.model.User;
import com.crowdsourcing.model.Worker;
import com.crowdsourcing.service.ClientService;


@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@RequestMapping(value="/clients", method = RequestMethod.GET)	
	public ResponseEntity<List<Client>> getClients() throws CoreException {		
		return new ResponseEntity<List<Client>>(clientService.getClients(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/client", method = RequestMethod.GET)	
	public ResponseEntity<Client> getClientById(@RequestParam("clientId") String clientId) throws CoreException {		
		return new ResponseEntity<Client>(clientService.getById(clientId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/client/create", method = RequestMethod.POST)	
	public ResponseEntity<Boolean> createClient(@RequestBody Client client) throws CoreException {		
		return new ResponseEntity<Boolean>(clientService.signUp(client), HttpStatus.CREATED);
	}
	
}
