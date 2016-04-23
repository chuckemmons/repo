package com.cee.webapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;

@Entity
@Scope(value = "session")
public class User implements Serializable {
	private static final long serialVersionUID = 4988491698022262976L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters.")
	private String firstName;
	
	@Size(min = 0, max = 30, message = "Last name must be less than 30 characters.")
	private String lastName;
	
	@NotBlank(message = "Email address is required.")
	@Email(message = "Email address must be a valid email address.")
	@Size(min = 0, max = 30, message = "Email address must be less than 30 characters.")
	private String email;
	
	@Size(min = 0, max = 10, message = "Phone number must be less than 10 numbers.")
	private String phone;
	
	@Size(min = 8, max = 20, message = "Password must be between 8 and 16 characters.")
	private String password;

	//private Set<Role> roles;


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*

	*//**
	 * @return the roles
	 *//*
	public Set<Role> getRoles() {
		return roles;
	}

	*//**
	 * @param roles
	 *            the roles to set
	 *//*
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}*/

}
