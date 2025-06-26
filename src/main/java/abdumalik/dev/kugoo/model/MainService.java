package abdumalik.dev.kugoo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MainService {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Photo photoId;
    @ManyToOne
    private ReelsMedia reelsMediaId;
    @Column(nullable = false)
    private String question;
    @ManyToOne
    private Contact contact;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}