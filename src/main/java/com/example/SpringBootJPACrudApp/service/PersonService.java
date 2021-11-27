package com.example.SpringBootJPACrudApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootJPACrudApp.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;

	public List<Person> getAllPersons() {
		
		return personRepo.findAll();
	}
	
	public void addPerson(Person person) {
		personRepo.save(person);
	}
	
	public void updatePerson(Person person, Integer id) {
		Optional<Person> personOpt = personRepo.findById(id);
		if(personOpt.isPresent()) {
			personRepo.save(person);
		}
	}
}
