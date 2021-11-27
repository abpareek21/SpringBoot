package com.example.SpringBootJPACrudApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJPACrudApp.model.Person;
import com.example.SpringBootJPACrudApp.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getPersonProfile() {
		
		List<Person> personList = personService.getAllPersons();
		return ResponseEntity.ok().body(personList);
	}
	
	@PostMapping("/person")
	public ResponseEntity<String> savePerson(@RequestBody Person person) {
		
		try {
			personService.addPerson(person);
			return ResponseEntity.ok().body("Patient saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().body("Error while saving patient");
	}
	
	@PutMapping("/person/{Id}")
	public void updatePerson(@RequestBody Person person, @PathVariable("Id") Integer id) {
		
		personService.updatePerson(person, id);
	}

}
