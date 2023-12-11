package ru.man.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PersonDto {
    @Length(min = 3, max = 50)
    private String username;
    @NotBlank
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
