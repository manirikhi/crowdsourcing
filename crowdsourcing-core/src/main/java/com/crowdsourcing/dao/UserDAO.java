package com.crowdsourcing.dao;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.model.User;

@Repository("userDAO")
public class UserDAO extends AbstractDAO<User> {
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class);

	public UserDAO() {
		super(User.class);
	}

	public boolean update(User user) throws CoreException {
	/*	Query searchuserQuery = new Query(Criteria.where("_id")
				.is(user.getId()));
		LOGGER.info("Before updating user " + user);
		Update update = new Update();
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastName());
		update.set("about", user.getAbout());
		update.set("lastModifiedOn", new Date());

		mongoTemplate.updateFirst(searchuserQuery, update, User.class);*/
		return true;
	}

	public User validateUser(String email, String password) {
		LOGGER.info("Validating user " + email);
		Query query = new Query(Criteria.where("email").is(email)
				.and("password").is(password));
		User user = mongoTemplate.findOne(query, User.class);
		LOGGER.info("User value = : " + user);
		return user;
	}
}
