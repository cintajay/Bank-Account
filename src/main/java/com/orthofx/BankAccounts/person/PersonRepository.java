package com.orthofx.BankAccounts.person;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> { //crudrep/jparep has many inbuild methods
	
}
