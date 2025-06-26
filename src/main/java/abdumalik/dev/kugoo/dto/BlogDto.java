package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private UUID photoId;
    private UUID productId;
    private String title;
    private UUID commentId;
    private String viewCount;

}