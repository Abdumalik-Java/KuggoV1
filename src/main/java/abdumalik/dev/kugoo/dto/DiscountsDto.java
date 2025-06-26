package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountsDto {

    private UUID photoId;
    private String title;
    private UUID productId;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

}