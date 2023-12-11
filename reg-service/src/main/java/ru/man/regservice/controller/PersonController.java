package ru.man.regservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.man.dto.NewPersonDto;
import ru.man.dto.PersonDto;
import ru.man.regservice.service.PersonService;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @PostMapping("/register")
    public ResponseEntity<PersonDto> register(@Valid @RequestBody NewPersonDto newPersonDto,
                                              HttpServletRequest request) {

        log.info("{} for {} with IP:{} EMAIL:{}",
                request.getMethod(), request.getRequestURI(), request.getRemoteAddr(), newPersonDto.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.register(newPersonDto));
    }
}
