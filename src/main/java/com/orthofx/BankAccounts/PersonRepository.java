package com.orthofx.BankAccounts;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> { //crudrep has many inbuild methods
	
}
