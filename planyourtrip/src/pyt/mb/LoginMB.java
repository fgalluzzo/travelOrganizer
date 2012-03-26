package pyt.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import pyt.auth.Authenticate;
import pyt.dao.LoginDAO;
import pyt.model.User;
import pyt.util.JPAUtil;

@ManagedBean(name="LoginMB")
@SessionScoped
public class LoginMB {
	private User user;
	private boolean isLogged = false;
	
	public LoginMB() {
		user = new User();
	}
	
	public String login() {
		EntityManager em = new JPAUtil().getEntityManager();
		LoginDAO dao = new LoginDAO(em);
		user = dao.login(user);
		if(user!=null) {
			Authenticate.login(user);
			isLogged = true;
			return "home";
		}		
		user = new User();
		return "index";
		
	}
	public void logout(){
		Authenticate.logout(this.user);
		this.user = new User();
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public boolean isLogged() {
		return isLogged;
	}


	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
