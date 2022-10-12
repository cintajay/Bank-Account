package com.orthofx.BankAccounts.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllPersons() { // public method to get the list
		List<Person> persons = personRepository.findAll();
		return persons;
	}

	public Optional<Person> getPerson(Long id) { // to get 1 person based on id
		return personRepository.findById(id); // findOne() didn't work
	}

	public void addPerson(Person person) {
		personRepository.save(person);
	}

	public void updatePerson(Long id, Person person) {
		personRepository.save(person);
	}

	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}

	public boolean checkPerson(Long id) {
		return personRepository.existsById(id);
	}
	
	public Person getOnePerson(Long id) {
		return personRepository.getOne(id);
	}
	
}
