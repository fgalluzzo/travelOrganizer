package pyt.auth;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import pyt.model.User;

public class Authenticate {
	
	public static void login(User user) {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("loggedUser", user);
	}
	
	public static void logout(User user) {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.removeAttribute("loggedUser");
	}
}
