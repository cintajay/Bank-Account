package com.orthofx.BankAccounts;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountControllers {
	
	@Autowired
	private BankService bankservice;
	
	@RequestMapping("/persons")
	public List<Person>getAllPersons(){
		return bankservice.getAllPersons();
	}

}
