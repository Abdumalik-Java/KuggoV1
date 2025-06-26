package abdumalik.dev.kugoo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Email
    private String email;
    @Size(min = 8, max = 20)
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,  unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private Boolean status;
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}