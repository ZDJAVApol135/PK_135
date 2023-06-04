package pl.sda.registrationapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private Long id;

    @Length(max = 50, message = "Title max length exceeded (max = 50)!")
    private String title;

    @NotBlank(message = "Specialization must not be blank!")
    private String specialization;

    @NotBlank(message = "Name must not be blank!")
    @Length(max = 50, message = "Name max length exceeded (max = 50)!")
    private String name;

    @NotBlank(message = "Surname must not be blank!")
    @Length(max = 50, message = "Name max length exceeded (max = 50)!")
    private String surname;

    @PastOrPresent(message = "Date of birth must not be in past or present!")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Phone number must not be blank!")
    @Length(max = 15, message = "Name max length exceeded (max = 15)!")
    private String phoneNumber;

}