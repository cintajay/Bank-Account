package com.orthofx.BankAccounts.person;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orthofx.BankAccounts.Accounts.Account;

@Entity
@Table(name="persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String name;
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, mappedBy="person") //mapped by=class name in small letters
	private List<Account> account;
	
	public Person() {
		super(); //?
	}
	
	public Person(Long id, String name) { 
		super();
		this.id = id;
		this.name = name;	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
