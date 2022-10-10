package com.orthofx.BankAccounts.Accounts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String accNumber;
	private String accType;
	
	public Account() {
		super(); //?
	}
	
	public Account(String accNumber, String accType) {
		super();
		this.accNumber = accNumber;
		this.accType = accType;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}	
	
}
