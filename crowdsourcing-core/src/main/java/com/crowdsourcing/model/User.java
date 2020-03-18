package com.crowdsourcing.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phoneNumber;
	private String about;
	private Date userCreationDate;
	private boolean isActive;
	private Date lastModifiedOn;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	/**
	 * @return the userCreationDate
	 */
	public Date getUserCreationDate() {
		return userCreationDate;
	}
	/**
	 * @param userCreationDate the userCreationDate to set
	 */
	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * @return the lastModifiedOn
	 */
	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}
	/**
	 * @param lastModifiedOn the lastModifiedOn to set
	 */
	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", email=" + email
				+ ", about=" + about + ", userCreationDate=" + userCreationDate
				+ ", isActive=" + isActive + "]";
	}
	
	
}
