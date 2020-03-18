package com.crowdsourcing.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clients")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * The client id will be same as user id
	 */
	@Id
	private String clientId;	
	private User details;	
	private PaymentRefrence  paymentRefrence;
	private List<String> taskIds = new ArrayList<>();
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}		
			
	public User getDetails() {
		return details;
	}
	public void setDetails(User details) {
		this.details = details;
	}
	public PaymentRefrence getPaymentRefrence() {
		return paymentRefrence;
	}
	public void setPaymentRefrence(PaymentRefrence paymentRefrence) {
		this.paymentRefrence = paymentRefrence;
	}
	public List<String> getTaskIds() {
		return taskIds;
	}
	public void setTaskIds(List<String> taskIds) {
		this.taskIds = taskIds;
	}
	/*@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", contactDetailId="
				+ contactDetailId + ", paymentRefrence=" + paymentRefrence
				+ ", taskIds=" + taskIds + "]";
	}*/
			    	
}
