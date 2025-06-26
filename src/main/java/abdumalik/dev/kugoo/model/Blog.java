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
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Photo photoId;
    @ManyToOne
    private Product productId;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    private Comment commentId;
    @Column(nullable = false)
    private String viewCount;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}