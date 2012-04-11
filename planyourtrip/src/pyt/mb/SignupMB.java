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

	public SignupMB() {
		user = new User();
	}

	public void signup() {
		FacesMessage message = null;
		EntityManager em = null;
		
		try {
			em = new JPAUtil().getEntityManager();			

			em.getTransaction().begin();

			user.setPassword(CriaHash.SHA1(user.getPassword()));

			em.persist(user);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					MessageUtil.getProperty("succesUserRegister"),
					MessageUtil.getProperty("succesUserRegister"));

			em.getTransaction().commit();

		} catch (NoSuchAlgorithmException e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					MessageUtil.getProperty("errorSignup"),
					MessageUtil.getProperty("errorSignup"));
			logger.error(MessageUtil.getProperty("errorSignup")
					+ " stackTrace: " + e.getMessage());

		} catch (UnsupportedEncodingException e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					MessageUtil.getProperty("errorSignup"),
					MessageUtil.getProperty("errorSignup"));
			logger.error(MessageUtil.getProperty("errorSignup")
					+ " stackTrace: " + e.getMessage());

		} catch (PersistenceException e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					MessageUtil.getProperty("errorSignup"),
					MessageUtil.getProperty("errorSignup"));
			logger.error(MessageUtil.getProperty("errorSignup")
					+ " stackTrace: " + e.getMessage());
		} finally {
			em.close();
			FacesContext.getCurrentInstance().addMessage(null, message);
			user = new User();
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
