package com.orthofx.BankAccounts.person;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orthofx.BankAccounts.Accounts.Account;
import com.orthofx.BankAccounts.exceptionHandling.ResourceNotFoundException;

@Service 
public class PersonConverterService {
	
	@Autowired
	private PersonRepository personRepository;
	
	private PersonDto EntityToDTO(Person person) { //conversion
		PersonDto dto= new PersonDto();
		dto.setId(person.getId());
		dto.setName(person.getName());
		return dto;
	}
		
	public Person DTOToEntity(PersonDto dto) {
		Person person= new Person();
		person.setId(dto.getId());
		person.setName(dto.getName());
		return person;
	}

	
	
	public List<PersonDto> getAllPersons(){ //method1
		return personRepository.findAll()
				.stream()
				.map(this::EntityToDTO) //conversion
				.collect(Collectors.toList());
	}
		
	public PersonDto getPerson(Long id) throws ResourceNotFoundException{
		Person person=personRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Person not found of id:"+id));
		PersonDto dto=EntityToDTO(person);	
		return dto;
	}
	public void addPerson(PersonDto dto) {
		Person person=DTOToEntity(dto);
		personRepository.save(person);
	}
	
	public Person getOnePerson(Long id) throws ResourceNotFoundException{     //for update to check if person exist
		return personRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Person not found of id:"+id));
	}
	
	public void updatePerson(Long id, PersonDto dto, Person existingPerson) {
		Person person=DTOToEntity(dto);
		existingPerson.setName(person.getName());
		personRepository.save(existingPerson);
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
