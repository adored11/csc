package com.mcgarry.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mcgarry.model.User;

 
public class PasswordValidator implements ConstraintValidator<CustomAnnotationPassword, Object> { 
     
       
  @Override
  public void initialize(CustomAnnotationPassword constraintAnnotation) {       
  }
   
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){   
                User user = (User) obj;
                   
               return user.getUserPassword().equals(user.getConfirmPassword());
         
       }   
}
