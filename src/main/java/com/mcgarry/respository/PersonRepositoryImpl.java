package com.mcgarry.respository;

import java.util.List;

import javax.mail.Session;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mcgarry.model.Person;


@Repository("personRespository")
public class PersonRepositoryImpl implements PersonRepository {

	/*
	 * @Autowired SessionFactory sessionFactory;
	 * 
	 * Session session = null; Transaction tx = null;
	 */
	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = false)
    @Override
   public Person save(Person p) {
     
    	jdbcTemplate.update("insert into user (username, password) values(?, ?)",
    			p.getName(),
    			p.getName()
    	);
        
    	return p;               
    }


}
