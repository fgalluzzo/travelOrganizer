package pyt.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import pyt.model.User;

public class LoginDAO {
	EntityManager em;
	public LoginDAO(EntityManager em) {
		this.em = em;
	}
	public User login(User user){
		try {
			String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
			TypedQuery<User> query =  em.createQuery(jpql, User.class);
			return query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}finally {
			em.close();
		}
		
	}
}
