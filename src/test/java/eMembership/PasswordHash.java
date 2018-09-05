package eMembership;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {
	
	/*public void testMD5Hah() {
		
		String password = "secret";
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String hashedPassword = passwordEncoder.encodePassword(password, null);
		System.out.println(hashedPassword);
	}*/
	
	public void testBcryptHash() {
		String password = "secret";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
	}
	public void testBcryptHashAdmin() {
		String password = "admin";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
	}
	
	public void testBcryptHashGuest() {
		String guestPassword = "gu3stUs£r";
		BCryptPasswordEncoder guestPasswordEncoder = new BCryptPasswordEncoder();
		String guestHashedPassword = guestPasswordEncoder.encode(guestPassword);
		System.out.println(guestHashedPassword);
	}
}