package com.bmo.rest.controller;

import com.bmo.rest.model.Person;
import com.bmo.rest.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    //For the access from local machine
    //private static final String CORS = "http://localhost:4200";

    //For the access from aws hosting application
    private static final String CORS = "http://bmofront.s3-website.us-east-2.amazonaws.com";

    @Autowired
    private PersonRepository personRepository;

    /**
     * url: "/persons"
     */
    @CrossOrigin(origins = CORS)
    @GetMapping(path="/persons", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Person> findAll() {
        LOGGER.info("searching all the persons");
        return personRepository.findAll();
    }

    /**
     * url: "persons/{firstName}"
     * @param firstName
     *
     */
    @CrossOrigin(origins = CORS)
    @GetMapping(path="/persons/{firstName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Person> findByFirstName(@PathVariable String firstName) {
        LOGGER.info("searching persons by first name: " + firstName);
        return personRepository.findByFirstName(firstName);
    }


    /**
     * url: "persons/?lastName='lastName'"
     *@param lastName
     *
     */
    @CrossOrigin(origins = CORS)
    @GetMapping(path="/persons/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Person> findByLastName(@RequestParam(value="lastName") String lastName) {
        LOGGER.info("searching persons by last name: " + lastName);
        return personRepository.findByLastName(lastName);
    }


}
