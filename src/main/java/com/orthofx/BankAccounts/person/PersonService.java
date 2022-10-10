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
	
	public List<Person> getAllPersons(){    //public method to get the list
		List<Person> persons =new ArrayList<>();
		personRepository.findAll()
		.forEach(persons::add);
		return persons;
	}
	
	public Optional<Person> getPerson(String id) {	//to get 1 person based on id
		return personRepository.findById(id); //findOne() didn't work
	}
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	public void updatePerson(String id, Person person) {
		personRepository.save(person);
	}
	public void deletePerson(String id) {
		personRepository.deleteById(id); 
	}
	
}
