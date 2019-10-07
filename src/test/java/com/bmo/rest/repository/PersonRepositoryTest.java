package com.bmo.rest.repository;

import com.bmo.rest.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findAllTest(){

        //given
        Person p1 = new Person();
        p1.setFirstName("AFirst");
        p1.setLastName("ALast");
        entityManager.persist(p1);
        entityManager.flush();

        Person p2 = new Person();
        p2.setFirstName("BFirst");
        p2.setLastName("BLast");
        entityManager.persist(p2);
        entityManager.flush();

        //when
        List<Person> persons = personRepository.findAll();

        //then
        assertThat(persons.size()).isEqualTo(2);
        assertThat(persons.get(0)).isEqualTo(p1);
        assertThat(persons.get(1)).isEqualTo(p2);
    }

    @Test
    public void findByFirstNameTest(){

        //given
        Person p1 = new Person();
        p1.setFirstName("AFirst");
        p1.setLastName("ALast");
        entityManager.persist(p1);
        entityManager.flush();

        //when
        List<Person> persons = personRepository.findByFirstName("AFirst");

        //then
        assertThat(persons.size()).isEqualTo(1);
        assertThat(persons.get(0).getFirstName()).isEqualTo(p1.getFirstName());
    }

    @Test
    public void findByLastNameTest(){
        //given
        Person p1 = new Person();
        p1.setFirstName("AFirst");
        p1.setLastName("ALast");
        entityManager.persist(p1);
        entityManager.flush();

        //when
        List<Person> persons = personRepository.findByLastName("ALast");

        //then
        assertThat(persons.size()).isEqualTo(1);
        assertThat(persons.get(0).getLastName()).isEqualTo(p1.getLastName());
    }
}
