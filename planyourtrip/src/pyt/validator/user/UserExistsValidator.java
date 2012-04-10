package pyt.validator.user;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import pyt.dao.UserDAO;
import pyt.util.JPAUtil;
import pyt.util.MessageUtil;


public class UserExistsValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String username = String.valueOf(value);
		UserDAO userDAO;
		userDAO = new UserDAO(new JPAUtil().getEntityManager());
		if(userDAO.existsUser(username)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					MessageUtil.getProperty("userAlreadyExists"),
					MessageUtil.getProperty("userAlreadyExists"));
			 throw new ValidatorException(message);
		}
		
	}
	
}
