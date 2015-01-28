package com.lakmal.jba.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Payload;

import javax.validation.Constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueUserNameValidator.class})
public @interface UniqueUserName {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
