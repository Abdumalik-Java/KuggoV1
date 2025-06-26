package abdumalik.dev.kugoo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Email
    private String email;
    @Size(min = 8, max = 20)
    private String password;
    private String phoneNumber;
    private Boolean status;

}