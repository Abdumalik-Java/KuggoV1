package abdumalik.dev.kugoo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Discounts {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany
    private List<Photo> photoId;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    private Product productId;
    @Column(nullable = false)
    private LocalDateTime fromDate;
    @Column(nullable = false)
    private LocalDateTime toDate;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}