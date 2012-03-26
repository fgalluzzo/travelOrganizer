package pyt.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pyt.model.User;

@ManagedBean
@ViewScoped
public class SignupMB {
	
	private User user;
	
	public SignupMB() {
		user = new User();
	}
	
	public void signup() {
		System.out.println("signup");
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
