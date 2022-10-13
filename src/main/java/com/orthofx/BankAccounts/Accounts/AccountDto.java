package com.orthofx.BankAccounts.Accounts;

import com.orthofx.BankAccounts.person.Person;

import lombok.Data;

@Data
public class AccountDto {
	private Long id;
	private String accNumber;
	private String accType;
	private Person person;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
