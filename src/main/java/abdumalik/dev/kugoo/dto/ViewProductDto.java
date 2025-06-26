package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewProductDto {

    private UUID productName;
    private Integer countView;
    private Double price;
    private String guarantee;
    private UUID categoryId;
    private Double serviceSum;
    private String color;
    private Double totalSum;
    private Boolean status;

}