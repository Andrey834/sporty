package ru.man.regservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.man.dto.NewPersonDto;
import ru.man.dto.PersonDto;
import ru.man.regservice.mapper.PersonMapper;
import ru.man.regservice.model.Person;
import ru.man.regservice.repository.PersonDao;
import ru.man.regservice.service.PersonService;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public PersonDto register(NewPersonDto newPersonDto) {
        newPersonDto.setPassword(encoder.encode(newPersonDto.getPassword()));
        final Person newPerson = personDao.save(PersonMapper.newPersonDtoToPerson(newPersonDto));

        log.info("REGISTER PERSON with UUID: {} EMAIL: {}", newPerson.getId(), newPerson.getEmail());

        return PersonMapper.personToPersonDto(newPerson);
    }
}
