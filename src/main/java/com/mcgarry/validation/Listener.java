package com.mcgarry.validation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.mcgarry.model.User;

public class Listener implements
ApplicationListener<Event>{
     
    private static ApplicationLogger logger = ApplicationLogFactory.getLogger(Listener.class);
 
    @Autowired
    private BaseDataDao basedatadao;
   
    @Autowired
    private MessageSource messages;
   
    @Autowired
    private JavaMailSender mailSender;
  
    @Override
    public void onApplicationEvent(Event event) {
        this.confirmRegistration(event);
    }
     
    private void confirmRegistration(Event event) {
        try{
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        basedatadao.generateVerificationToken(user, token);
          
        String recipientAddress = user.getEmail();
        String subject = "Account Activation";
        String confirmationUrl= event.getAppUrl() + "/registrationConfirm?token=" + token;
        String message = "Hello User Please verify yourself";
         
         
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message +" " +"http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
        }catch(Exception e){
            logger.logError("Email Error", "Error while sending email", e);
        }
    }
}
