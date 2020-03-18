package com.crowdsourcing.service;

import java.util.List;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.User;


public interface UserService {
	public boolean addUser(User user) throws CoreException;
	public List<User> getUsers() throws CoreException;
	public User getUserById(String userId) throws CoreException;
	public boolean updateUser(User user) throws CoreException;
	public boolean deleteUser(String userId) throws CoreException;
	
	public Boolean signUp(User user) throws CoreException;
	public Boolean signIn(String emailId,String password) throws CoreException;
}
