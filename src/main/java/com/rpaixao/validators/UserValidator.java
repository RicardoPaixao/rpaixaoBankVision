package com.rpaixao.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rpaixao.models.User;
import com.rpaixao.repositories.UserRepository;

@Component("beforeCreateUser")
public class UserValidator implements Validator {

	@Autowired
	private UserRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;

		if (user.getDocumento() != null && !user.getDocumento().matches("(?=[^A-Za-z]+$).*[0-9].*")) {
			errors.rejectValue("documento", "invalidFormat");
		}

		if (user.getTelefono() != null && !user.getTelefono().matches("(?=[^A-Za-z]+$).*[0-9].*")) {
			errors.rejectValue("telefono", "invalidFormat");
		}

		if (user.getCorreo() != null
				&& !user.getCorreo().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
			errors.rejectValue("correo", "invalidFormat");
		}
		
		if (repository.findByCorreo(user.getCorreo())!=null) {
			errors.rejectValue("correo", "duplicate");
		}
		
		if (repository.findByDocumento(user.getDocumento())!=null) {
			errors.rejectValue("documento", "duplicate");
		}
	}
}