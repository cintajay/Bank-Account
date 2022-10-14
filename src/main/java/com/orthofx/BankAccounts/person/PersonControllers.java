package com.orthofx.BankAccounts.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonControllers {

	@Autowired 
	private PersonConverterService personService;
	
	@RequestMapping("/persons")
	public List<PersonDto> getAllPersons() { //list of person dto
		return personService.getAllPersons(); //getting from dto instead of rep //ie dto object is send
	}
	
	@RequestMapping("/persons/{id}") 
	public PersonDto getPerson(@PathVariable Long id) {
		return personService.getPerson(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/persons") 
	public void addPerson(@RequestBody PersonDto dto) { 
		personService.addPerson(dto);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/persons/{id}") //if person doesnt exist it posts as new element, this shouldnt happen
	public void updatePerson(@RequestBody PersonDto dto, @PathVariable Long id) {
		Person existingPerson=personService.getOnePerson(id);	
		personService.updatePerson(id, dto, existingPerson);					
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/persons/{id}") //gives internal server error if trying to access non existent person
	public void deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
	}
}
