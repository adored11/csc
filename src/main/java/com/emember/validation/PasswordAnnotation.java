package com.emember.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
 
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
import javax.validation.Constraint;
import javax.validation.Payload;
 
@Target({TYPE,ANNOTATION_TYPE}) 
@Retention(RUNTIME)
//@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface PasswordAnnotation {
      String message() default "Passwords do not match";
        Class<?>[] groups() default {}; 
        Class<? extends Payload>[] payload() default {};
}
