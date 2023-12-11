package ru.man.regservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.man.regservice.model.Person;

import java.util.UUID;

@Repository
public interface PersonDao extends JpaRepository<Person, UUID> {
}
