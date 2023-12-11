package ru.man.regservice.mapper;

import ru.man.dto.NewPersonDto;
import ru.man.dto.PersonDto;
import ru.man.regservice.model.Person;

public class PersonMapper {
    public static Person newPersonDtoToPerson(NewPersonDto newPersonDto) {
        return Person.builder()
                .username(newPersonDto.getUsername())
                .password(newPersonDto.getPassword())
                .email(newPersonDto.getEmail())
                .phone(newPersonDto.getPhone())
                .firstName(newPersonDto.getFirstName())
                .lastName(newPersonDto.getLastName())
                .birthday(newPersonDto.getBirthday())
                .build();
    }

    public static PersonDto personToPersonDto(Person person) {
        return PersonDto.builder()
                .username(person.getUsername())
                .email(person.getEmail())
                .phone(person.getPhone())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .birthday(person.getBirthday())
                .build();

    }
}
