package com.mcgarry.respository.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
	
	public String encPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String guestHashedPassword = passwordEncoder.encode(password);
		return guestHashedPassword;
	}

}
