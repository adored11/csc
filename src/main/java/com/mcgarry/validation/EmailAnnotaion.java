package com.mcgarry.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Payload;
 
 
@Target({TYPE, FIELD, ANNOTATION_TYPE}) 
@Retention(RUNTIME)
@Constraint(validatedBy = {Emailvalid.class})
@Documented
public @interface EmailAnnotaion{
     String message() default "Email pattern incorrect";
     Class<?>[] groups() default {}; 
     Class<? extends Payload>[] payload() default {};
      
}
