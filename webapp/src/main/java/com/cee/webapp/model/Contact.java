package com.cee.webapp.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Contact implements Serializable {
	private static final long serialVersionUID = -6421061248949500547L;

	@Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters.")
	private String firstName;
	private String lastName;
	@NotBlank(message = "Email address is required.")
	@Email(message = "Email must be a valid email address.")
	private String email;
	private String phone;
	private String subject;
	@NotBlank(message = "Message is required.")
	private String message;
	private String url; // used to detect spambots.

	public Contact() {
	}

	public Contact(String firstName, String lastName, String email,
			String phone, String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}

	public boolean notSpam() {
		// if url is set, it was done by a bot...
		return StringUtils.isBlank(url);
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * @return The contact's signature: firstName lastName, phone number, email
	 *         address
	 */
	public String getSignature() {
		StringBuilder sb = new StringBuilder();
		// add name
		if (StringUtils.isNotBlank(firstName)) {
			sb.append(getFullName()).append("\n");
		}
		// add phone
		if (StringUtils.isNotBlank(phone)) {
			sb.append("Phone: ").append(phone).append("\n");
		}
		// add email
		if (StringUtils.isNotBlank(email)) {
			sb.append("Email: ").append(email).append("\n");
		}
		return sb.toString();
	}

	public String getMessageWithSignature() {
		return message + "\n\n\n" + getSignature();
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
