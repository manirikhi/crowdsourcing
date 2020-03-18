package com.crowdsourcing.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.crowdsourcing.dao.UserDAO;
import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.User;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	public boolean addUser(User user) throws CoreException {
		return userDAO.create(user);
	}

	public List<User> getUsers() throws CoreException {
		return userDAO.getAll();
	}

	public User getUserById(String id) throws CoreException {
		return userDAO.getById(id);
	}

	public boolean updateUser(User user) throws CoreException {
		
		User existingUser = userDAO.getById("1");
		if(user.getFirstName()!=null){
			existingUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName()!=null){
			existingUser.setLastName(user.getLastName());
		}
		if(user.getPassword()!=null){
			existingUser.setPassword(user.getPassword());
		}
		if(user.getAbout()!=null){
			existingUser.setAbout(user.getAbout());
		}
		if(user.getUserCreationDate()!=null){
			existingUser.setLastModifiedOn(user.getLastModifiedOn());
		}
		
		return userDAO.update(user);
	}

	public boolean deleteUser(String userId) throws CoreException {
		return userDAO.deleteById(userId);
	}
	
	public User validateUser(String email,String password){
		return userDAO.validateUser(email, password);
	}

	@Override
	public Boolean signUp(User user) throws CoreException {		
		return userDAO.create(user);
	}

	@Override
	public Boolean signIn(String email,String password) throws CoreException {
		
		Query searchUserQuery = new Query(Criteria.where("email").is(email));
		      searchUserQuery.addCriteria(Criteria.where("password").is(password));		   
		      
			return !userDAO.find(searchUserQuery).isEmpty();		
	}
}
