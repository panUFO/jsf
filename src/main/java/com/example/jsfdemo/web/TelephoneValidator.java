package com.example.jsfdemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("telephoneValidator")
public class TelephoneValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String telephone = (String)value;

		//Converting to telephone number without "-" sign
		if (telephone.contains("-")) {
			telephone = telephone.replace("-", "");
		}
		
		if (telephone.length() != 9) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Numer telefonu musi składać się z 9 cyfr");
			message.setSummary("Numer telefonu musi składać się z 9 cyfr");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

		for (int i=0; i < telephone.length(); i++) {
			try {
				int number = Integer.parseInt(Character.toString(telephone.charAt(i)));
			}
			catch (Exception e) {
				FacesMessage message = new FacesMessage();
				message.setDetail("Numer telefonu może składać się jedynie z cyfr i ewentualnie myślników");
				message.setSummary("Numer telefonu może składać się jedynie z cyfr i ewentualnie myślników");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}
