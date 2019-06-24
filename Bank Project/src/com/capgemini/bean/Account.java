package com.capgemini.bean;

import java.util.Date;

/**
 * 
 * @author DOLA SAI RAM
 *
 */
public class Account {
	
	private String firstName;
	private String lastName;
	private String fathersName;
	private String mothersName;
	private Long accountId;
	private String password;
	private String address;
	private Double balance=0.0;
	
	public Account() {
		super();
	}
	
	public Account(String firstName, String lastName, String fathersName, String mothersName, Long accountId,
			String password, String address, Double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fathersName = fathersName;
		this.mothersName = mothersName;
		this.accountId = accountId;
		this.password = password;
		this.address = address;
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long rand) {
		this.accountId = rand;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [firstName=" + firstName + ", lastName=" + lastName + ", accountId=" + accountId + "]\n";
	}
}
