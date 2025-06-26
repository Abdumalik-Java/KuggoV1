package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainServiceDto {

    private UUID photoId;
    private UUID reelsMediaId;
    private String question;
    private UUID contact;

}