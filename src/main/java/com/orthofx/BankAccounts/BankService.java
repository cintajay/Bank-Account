package com.orthofx.BankAccounts;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BankService {
	
	private List<Person> persons= Arrays.asList(   //private list of persons
			new Person(1,"cinta"),
			new Person(2,"jose")
			);
	
	public List<Person> getAllPersons(){    //public method to get the list
		return persons;
	}
}
