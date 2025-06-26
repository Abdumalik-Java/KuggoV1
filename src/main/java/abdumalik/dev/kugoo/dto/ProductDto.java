package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private UUID photoId;
    private String name;
    private Integer power;
    private Integer speed;
    private Integer hour;
    private Double price;
    private UUID cartId;
    private UUID likeId;
    private UUID cardId;

}