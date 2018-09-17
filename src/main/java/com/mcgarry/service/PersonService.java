package com.mcgarry.service;

import java.util.List;

import com.mcgarry.model.Person;

public interface PersonService {
	public Person save(Person p);

	public List<Person> list();

}
