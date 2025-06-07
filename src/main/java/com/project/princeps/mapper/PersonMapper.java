package com.project.princeps.mapper;

import com.project.princeps.dto.PersonDTO;
import com.project.princeps.entity.Person;
import org.springframework.stereotype.Component;


@Component
public class PersonMapper {

    public PersonDTO toDto(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .answer(person.getAnswer())
                .build();
    }

    public Person toEntity(PersonDTO personDTO) {
        return Person.builder()
                .id(personDTO.getId())
                .answer(personDTO.getAnswer())
                .build();
    }

}
