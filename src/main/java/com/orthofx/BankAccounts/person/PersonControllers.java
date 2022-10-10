package com.orthofx.BankAccounts.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonControllers {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/persons")
	public List<Person>getAllPersons(){
		return personService.getAllPersons();
	}
	
	@RequestMapping("/persons/{id}")  //default is get
	public Optional<Person> getPerson(@PathVariable String id) {
		return personService.getPerson(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/persons") //post is specified
	public void addPerson(@RequestBody Person person) { //converts from JSON to object of type Person
		personService.addPerson(person);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/persons/{id}") 
	public void updatePerson(@RequestBody Person person, @PathVariable String id) { 
		personService.updatePerson(id, person);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/persons/{id}") 
	public void deletePerson(@PathVariable String id) {
		personService.deletePerson(id);
	}
}
