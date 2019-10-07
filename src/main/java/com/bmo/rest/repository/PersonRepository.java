package com.bmo.rest.repository;

import com.bmo.rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface PersonRepository extends JpaRepository<Person, Long> {


        List<Person> findAll();

        List<Person> findByFirstName(String firstName);

        List<Person> findByLastName(String lastName);

}
