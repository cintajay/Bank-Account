package com.orthofx.BankAccounts;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> { //crudrep has many inbuild methods
	
}
