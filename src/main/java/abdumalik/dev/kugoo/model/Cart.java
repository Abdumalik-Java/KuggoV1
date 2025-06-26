package abdumalik.dev.kugoo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Photo photoId;
    @Column(nullable = false)
    private Integer count;
    @Column(nullable = false)
    private Double totalSum;
    @ManyToMany
    private List<Card> cardId;

}