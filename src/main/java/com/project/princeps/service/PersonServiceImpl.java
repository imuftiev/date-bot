package com.project.princeps.service;

import com.project.princeps.entity.Person;
import com.project.princeps.repository.PersonRepository;
import com.project.princeps.service.contract.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void add(Person person) {
        try {
            personRepository.save(person);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
