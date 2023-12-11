package ru.man.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Data

@NoArgsConstructor
@AllArgsConstructor
public class NewPersonDto {
    @Length(min = 3, max = 50)
    private String username;
    @Length(min = 8, max = 100)
    private String password;
    @Email
    private String email;
    @Length(min = 11, max = 12)
    private String phone;
    @Length(min = 2, max = 50)
    private String firstName;
    @Length(min = 2, max = 50)
    private String lastName;
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
