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
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Photo photoId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer power;
    @Column(nullable = false)
    private Integer speed;
    @Column(nullable = false)
    private Integer hour;
    @Column(nullable = false)
    private Double price;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Like like;
    @ManyToOne
    private Card card;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}