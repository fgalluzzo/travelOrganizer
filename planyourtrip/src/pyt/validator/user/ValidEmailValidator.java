package pyt.validator.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import pyt.util.MessageUtil;

public class ValidEmailValidator implements Validator {
	
	public void validate(FacesContext context, UIComponent uiComponent,
			Object object) throws ValidatorException {
		String enteredEmail = String.valueOf(object);
		// Set the email pattern string
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		// Match the given string with the pattern
		Matcher m = p.matcher(enteredEmail);

		// Check whether match is found
		boolean matchFound = m.matches();

		if (!matchFound) {
			FacesMessage message = new FacesMessage();
			message.setDetail(MessageUtil.getProperty(
					"invalidEmail"));
			message.setSummary(MessageUtil.getProperty(
					"invalidEmail"));
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}
}
