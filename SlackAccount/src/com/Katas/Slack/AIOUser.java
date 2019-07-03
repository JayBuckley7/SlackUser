package com.Katas.Slack;
public class AIOUser {

	/*
	 * Private Members
	 */
	private String FirstName;
	private String LastName;
	private String EmailAccount;
	

	/*
	 * Consturctor
	 */
	public AIOUser(String FirstName, String LastName, String Email) {
		this.setFirstName(FirstName);
		this.setLastName(LastName);
		this.setEmailAccount(Email);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the emailAccount
	 */
	public String getEmailAccount() {
		return EmailAccount;
	}

	/**
	 * @param emailAccount the emailAccount to set
	 */
	public void setEmailAccount(String emailAccount) {
		EmailAccount = emailAccount;
	}

}
