package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private UUID photoId;
    private Integer count;
    private Double totalSum;
    private UUID cardId;

}