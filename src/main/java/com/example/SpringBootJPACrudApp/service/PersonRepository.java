package com.example.SpringBootJPACrudApp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootJPACrudApp.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
