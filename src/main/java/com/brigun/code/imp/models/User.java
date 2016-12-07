package com.brigun.code.imp.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="user")
public class User 
{
	private String userName;
	private int role;
	private long userId;
	private String hashedPass;
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	public User (){}
	
	public User(String name, int role, String password)
	{
		if (!isValidUsername(name))
		{
			throw new IllegalArgumentException("Invalid User Name");
		}
		this.userName = name;
		this.role = role;
		this.hashedPass =  hashPassword(password);
	}
	
	public static boolean isValidUsername(String username)
	{
		Pattern validUsernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
		Matcher matcher = validUsernamePattern.matcher(username);
		return matcher.matches();
	}
	
	public static boolean isValidPassword(String password) 
	{
		Pattern validUsernamePattern = Pattern.compile("(\\S){6,20}");
		Matcher matcher = validUsernamePattern.matcher(password);
		return matcher.matches();
	}
	
	private static String hashPassword(String password)
	{
		return encoder.encode(password);
	}
	
	@Column(name = "username", unique = true)
	@NotNull
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "role")
	@NotNull
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "user_id", unique = true)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@NotNull
	@Column( name = "hashed")
	public String getHashedPass() {
		return hashedPass;
	}

	public void setHashedPass(String hashedPass) {
		this.hashedPass = hashedPass;
	}
	
	public boolean isMatchingPassword(String password)
	{
		return encoder.matches(password, hashedPass);
	}
}
