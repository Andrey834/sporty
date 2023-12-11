package ru.man.regservice.service;

import ru.man.dto.NewPersonDto;
import ru.man.dto.PersonDto;

public interface PersonService {
    PersonDto register(NewPersonDto newPersonDto);
}
