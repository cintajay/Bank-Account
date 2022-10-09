package com.orthofx.BankAccounts;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountControllers {
	
	@Autowired
	private BankService bankservice;
	
	@RequestMapping("/persons")
	public List<Person>getAllPersons(){
		return bankservice.getAllPersons();
	}
	
	@RequestMapping("/persons/{id}")  //default is get
	public Person getPerson(@PathVariable String id) {
		return bankservice.getPerson(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/persons") //post is specified
	public void addPerson(@RequestBody Person person) { //converts from JSON to object of type Person
		bankservice.addPerson(person);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/persons/{id}") 
	public void updatePerson(@RequestBody Person person, @PathVariable String id) { 
		bankservice.updatePerson(id, person);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/persons/{id}") 
	public void deletePerson(@PathVariable String id) {
		bankservice.deletePerson(id);
	}
}
