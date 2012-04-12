package pyt.mb;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import pyt.auth.hash.CriaHash;
import pyt.model.User;
import pyt.util.JPAUtil;
import pyt.util.MessageUtil;

@ManagedBean
@RequestScoped
public class SignupMB {

	private Logger logger = Logger.getLogger("Signup Log");
	private User user;
	private boolean success = false;
	private String msg;

	public SignupMB() {
		user = new User();
	}

	public void signup() {	
		EntityManager em = null;

		try {		
			em = new JPAUtil().getEntityManager();

			em.getTransaction().begin();

			user.setPassword(CriaHash.SHA1(user.getPassword()));

			em.persist(user);

			em.getTransaction().commit();
			msg= MessageUtil.getProperty("succesUserRegister");
			success = true;

		} catch (NoSuchAlgorithmException e) {
			msg= MessageUtil.getProperty("errorSignup");
			logger.error(MessageUtil.getProperty("errorSignup")
					+ " stackTrace: " + e.getMessage());

		} catch (UnsupportedEncodingException e) {
			msg= MessageUtil.getProperty("errorSignup");
			logger.error(MessageUtil.getProperty("errorSignup")
					+ " stackTrace: " + e.getMessage());

		} catch (PersistenceException e) {
			msg= MessageUtil.getProperty("errorSignup");
			logger.error(MessageUtil.getProperty("errorSignup")
					+ " stackTrace: " + e.getMessage());
		} finally {
			em.close();			
			user = new User();
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
