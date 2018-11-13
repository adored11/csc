package com.emember.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;*/
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.emember.validation.EmailAnnotaion;
import com.emember.validation.PasswordAnnotation;

//import in.hkcl.login.validation.CustomAnnotationEmail;
//import in.hkcl.login.validation.CustomAnnotationPassword;

//@Entity
//@Table(name = "user_master")
//@PasswordAnnotation
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int EXPIRATION = 60 * 24 * 87;

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", unique = true, nullable = false)
	private Integer userId;

	@NotNull
	@NotEmpty
	@Column(name = "candidateName")
	private String candidateName;

	@NotNull
	@NotEmpty
	@EmailAnnotaion
	@Column(name = "email")
	private String email;

	@NotNull
	@NotEmpty
	@Column(name = "userName")
	private String userName;

	@NotNull
	@NotEmpty
	@Column(name = "userPassword")
	private String userPassword;

	@Transient
	private String confirmPassword;

	@Column(name = "enabled")
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}*/

}
