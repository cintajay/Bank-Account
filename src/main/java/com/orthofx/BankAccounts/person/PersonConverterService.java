package com.orthofx.BankAccounts.person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
	public PersonDto getPerson(Long id) {
		Person person=personRepository.getOne(id);	
		PersonDto dto=EntityToDTO(person);	
		return dto;
	}
	public void addPerson(PersonDto dto) {
		Person person=DTOToEntity(dto);
		personRepository.save(person);
	}
	public boolean checkPerson(Long id) {
		return personRepository.existsById(id);
	}
	public Person getOnePerson(Long id) {
		return personRepository.getOne(id);
	}
	public void updatePerson(Long id, Person person) {
		personRepository.save(person);
	}
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
