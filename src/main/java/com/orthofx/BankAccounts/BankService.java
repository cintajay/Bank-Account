package com.orthofx.BankAccounts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BankService {
	
	private List<Person> persons= new ArrayList<>(Arrays.asList(   //private list of persons
			new Person("1","cinta"),                               //'new ArrayList' to add new person since Arrays.asList creates an immutable list
			new Person("2","jose")
			));
	
	public List<Person> getAllPersons(){    //public method to get the list
		return persons;
	}
	
	public Person getPerson(String id) {	//to get 1 person based on id
		return persons.stream().filter(p -> p.getId().equals(id)).findFirst().get();
	}
	public void addPerson(Person person) {
		persons.add(person);
	}
	public void updatePerson(String id, Person person) {
		for(int i=0;i<persons.size();i++) {
			Person p= persons.get(i);
			if(p.getId().equals(id)) {
				persons.set(i, person);
				return;
			}
		}
	}
	public void deletePerson(String id) {
		persons.removeIf(p -> p.getId().equals(id));
	}
	
}
