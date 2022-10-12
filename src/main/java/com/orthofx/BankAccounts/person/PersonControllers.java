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

import com.orthofx.BankAccounts.exceptionHandling.ResourceNotFoundException;

@RestController
public class PersonControllers {

	@Autowired // for dependency injection
	private PersonService personService;

	@RequestMapping("/persons")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@RequestMapping("/persons/{id}")   //default is get
//	@ResponseStatus(HttpStatus.OK)
	public Optional<Person> getPerson(@PathVariable Long id) {
		return personService.getPerson(id);
//				.orElseThrow(()-> new ResourceNotFoundException("Person not found of id:"+id));
		}

	@RequestMapping(method = RequestMethod.POST, value = "/persons") // post is specified
	public void addPerson(@RequestBody Person person) { // converts from JSON to object of type Person
		personService.addPerson(person);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/persons/{id}") //if person doesnt exist it posts as new element, this shouldnt happen
	public void updatePerson(@RequestBody Person person, @PathVariable Long id) {
			if(personService.checkPerson(id)) {
				Person existingPerson=personService.getOnePerson(id);
				existingPerson.setName(person.getName());
				personService.updatePerson(id, existingPerson);
			}
			else {
				personService.updatePerson(id, person); //or throw exception
			}				
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/persons/{id}") //gives internal server error if trying to access non existent person
	public void deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
	}
}
