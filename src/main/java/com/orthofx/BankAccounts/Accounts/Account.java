package com.orthofx.BankAccounts.Accounts;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.orthofx.BankAccounts.person.Person;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String accNumber;
	private String accType;
	@ManyToOne
	private Person person;
	
	public Account() {
		super(); //?
	}
	
	public Account(Long id, String accNumber, String accType, Long personId ) { //how do we get personId?
		super();
		this.id=id; 
		this.accNumber = accNumber;
		this.accType = accType;
		this.person= new Person(personId,"");
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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
