package com.lakmal.jba.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lakmal.jba.repository.UserRepository;

public class UniqueUserNameValidator implements
		ConstraintValidator<UniqueUserName, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (null == userRepository) {
			return true;
		}
		return userRepository.findByName(value) == null;
	}

}
