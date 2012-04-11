package pyt.mb;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import pyt.auth.hash.CriaHash;
import pyt.constants.PageNames;
import pyt.dao.LoginDAO;
import pyt.model.User;
import pyt.util.JPAUtil;
import pyt.util.MessageUtil;

@ManagedBean(name = "LoginMB")
@SessionScoped
public class LoginMB {
	private String username;
	private String password;
	private User user;
	private boolean logged = false;
	private String lastPage = "";

	public LoginMB() {
		user = new User();
	}

	public String login() {
		try {
			FacesMessage message = null;
			EntityManager em = new JPAUtil().getEntityManager();
			LoginDAO dao = new LoginDAO(em);
			User u = new User();
			u.setUsername(username);

			u.setPassword(CriaHash.SHA1(password));
			username = new String();
			password = new String();
			user = dao.login(u);
			if (user != null) {
				setLogged(true);				
				return "".equals(lastPage) ? PageNames.HOME_PAGE : lastPage;
			}
			message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					MessageUtil.getProperty("userNotFound"),
					MessageUtil.getProperty("userNotFound"));
			FacesContext.getCurrentInstance().addMessage(null, message);
			user = new User();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}

	public String logout() {		
		this.user = new User();
		logged = false;
		return "index?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}
