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
public class ViewProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> productName;
    @Column(nullable = false)
    private Integer countView;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String guarantee;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @Column(nullable = false)
    private Double serviceSum;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private Double totalSum;
    @Column(nullable = false)
    private Boolean status;

}