package com.emember.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
 
/*public class Emailvalid implements ConstraintValidator<CustomAnnotationEmail, String>{
           
       private Pattern pattern;
       private   Matcher matcher;
        private static final String EMAIL_PATTERN = "Email Regex Pattern Search it from google and paste it here";
  
        @Override
        public void initialize(CustomAnnotationEmail constraintAnnotation) {       
        }
        
         
        @Override                                              
        public boolean isValid(String email, ConstraintValidatorContext context){   
            return (validateEmail(email));
        } 
        public boolean validateEmail(String email) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = ( pattern).matcher(email);
            System.out.println(matcher.matches());
            return matcher.matches();
        }
         
}*/
