package com.orthofx.BankAccounts.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id; //string used to avoid error in equals method in service
	private String name;
//	private Account account;
	
	public Person() {
		super(); //?
	}
	
	public Person(String id, String name) { 
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//	public Account getAccount() {
//		return account;
//	}
//	public void setAccount(Account account) {
//		this.account = account;
//	}

}
