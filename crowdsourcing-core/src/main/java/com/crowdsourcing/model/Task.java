package com.crowdsourcing.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String taskId;
	private String taskName;
	private String taskDescription;
	private String taskLocation;
	private String taskTimeLimit;	
	private String taskBudget;
	private Double taskRating;
	private Boolean taskCompleted;
	private Boolean taskAssigned;
	//CSV
	private String requiredSkills;
	private Double requiredCredibiliy;
	private String clientId;	
		
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskTimeLimit() {
		return taskTimeLimit;
	}
	public void setTaskTimeLimit(String taskTimeLimit) {
		this.taskTimeLimit = taskTimeLimit;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskLocation() {
		return taskLocation;
	}
	public void setTaskLocation(String taskLocation) {
		this.taskLocation = taskLocation;
	}
	public String getTaskLimit() {
		return taskTimeLimit;
	}
	public void setTaskLimit(String taskLimit) {
		this.taskTimeLimit = taskLimit;
	}
	public String getTaskBudget() {
		return taskBudget;
	}
	public void setTaskBudget(String taskBudget) {
		this.taskBudget = taskBudget;
	}		
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Double getTaskRating() {
		return taskRating;
	}
	public void setTaskRating(Double taskRating) {
		this.taskRating = taskRating;
	}
	public Boolean getTaskCompleted() {
		return taskCompleted;
	}
	public void setTaskCompleted(Boolean taskCompleted) {
		this.taskCompleted = taskCompleted;
	}	
		
	public String getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public Double getRequiredCredibiliy() {
		return requiredCredibiliy;
	}
	public void setRequiredCredibiliy(Double requiredCredibiliy) {
		this.requiredCredibiliy = requiredCredibiliy;
	}	
	public Boolean getTaskAssigned() {
		return taskAssigned;
	}
	public void setTaskAssigned(Boolean taskAssigned) {
		this.taskAssigned = taskAssigned;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", taskLocation=" + taskLocation + ", taskTimeLimit=" + taskTimeLimit + ", taskBudget=" + taskBudget
				+ ", taskRating=" + taskRating + ", taskCompleted=" + taskCompleted + ", taskAssigned=" + taskAssigned
				+ ", requiredSkills=" + requiredSkills + ", requiredCredibiliy=" + requiredCredibiliy + ", clientId="
				+ clientId + "]";
	}
	
	
		
}
