package com.crowdsourcing.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "workers")
public class Worker implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	private String workerId;
	private User details;	
	/**
	 * CSV skills keywords
	 */
	private String skills;
	private String workerLocation;
	private Double workExperience;
	private Double workCredibility;
	/**
	 * This list will have task ids and their ratings
	 */
	private List<String> taskIds;
	private List<String> rejectedTaskIds;
	
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}		
	public User getDetails() {
		return details;
	}
	public void setDetails(User details) {
		this.details = details;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getWorkerLocation() {
		return workerLocation;
	}
	public void setWorkerLocation(String workerLocation) {
		this.workerLocation = workerLocation;
	}	
	public List<String> getTaskIds() {
		return taskIds;
	}
	public void setTaskIds(List<String> taskIds) {
		this.taskIds = taskIds;
	}	
	public Double getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(Double workExperience) {
		this.workExperience = workExperience;
	}
	public Double getWorkCredibility() {
		return workCredibility;
	}
	public void setWorkCredibility(Double workCredibility) {
		this.workCredibility = workCredibility;
	}
	public List<String> getRejectedTaskIds() {
		return rejectedTaskIds;
	}
	public void setRejectedTaskIds(List<String> rejectedTaskIds) {
		this.rejectedTaskIds = rejectedTaskIds;
	}	
	
	
}
