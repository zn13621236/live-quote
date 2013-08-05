package com.archer.livequote.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueIDValidator.class)
@Documented
public @interface Unique {
	 String message() default "{com.archer.livequote.validator.uniques}";
	 
	    Class<?>[] groups() default {};
	 
	    Class<? extends Payload>[] payload() default {};
	 
	    /**
	     * The mapped mongo entity class
	     */
	    Class<?> entity();
	 
	    /**
	     * The property of the entity we want to validate for uniqueness. Default name is "user_name"
	     */
	    String property() default "user_name";
}
