package com.emember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emember.model.Person;
import com.emember.repository.PersonRepository;
 
@Repository("personService")
@Transactional
public class PersonServiceImpl implements PersonService {
 
	@Autowired
	private PersonRepository personRepository;
     
    @Override
    public Person save(Person p) {
        return personRepository.save(p);
         
    }
 
   /* @Override
    public List<Person> list() {
         
        return personRepository.list();
    }*/
 
}
