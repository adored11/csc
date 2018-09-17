package com.mcgarry.validation;

import java.util.Locale;

import javax.persistence.Column;
 
import org.springframework.context.ApplicationEvent;

import com.mcgarry.model.User;
 
@SuppressWarnings("serial")
public class Event extends ApplicationEvent {
     
    @Column(name="appUrl")
    private String appUrl;
     
    @Column(name="locale")
    private Locale locale;
     
     
    private User user;
 
    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
                super(user);
                  
                this.user = user;
                this.locale = locale;
                this.appUrl = appUrl;
            }
 
    public String getAppUrl() {
        return appUrl;
    }
 
    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
 
    public Locale getLocale() {
        return locale;
    }
 
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
     
}
