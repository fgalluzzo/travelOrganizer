package pyt.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import pyt.model.User;

public class UserDAO {
	EntityManager em;

	public UserDAO(EntityManager em) {
		this.em = em;
	}

	public boolean existsUser(String username) {
		try {
			String jpql = "SELECT u FROM User u WHERE u.username = :username";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
		

	}
}
