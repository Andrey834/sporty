package ru.man.regservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Length(min = 3, max = 50)
    @Column(name = "username", unique = true, length = 50, nullable = false)
    private String username;
    @Column(name = "password", length = 3000, nullable = false)
    private String password;
    @Email
    @Column(name = "email", unique = true, length = 300, nullable = false)
    private String email;
    @Length(min = 11, max = 12)
    @Column(name = "phone", unique = true, length = 12, nullable = false)
    private String phone;
    @Length(min = 2, max = 50)
    private String firstName;
    @Length(min = 2, max = 50)
    private String lastName;
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private LocalDateTime created;

    @PrePersist
    private void createdAt() {
        this.created = LocalDateTime.now();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id)
               && Objects.equals(username, person.username)
               && Objects.equals(password, person.password)
               && Objects.equals(email, person.email)
               && Objects.equals(phone, person.phone)
               && Objects.equals(firstName, person.firstName)
               && Objects.equals(lastName, person.lastName)
               && Objects.equals(birthday, person.birthday)
               && Objects.equals(created, person.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, phone, firstName, lastName, birthday, created);
    }
}
