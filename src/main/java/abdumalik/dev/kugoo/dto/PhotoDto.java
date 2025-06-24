package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {

    private String name;
    private String size;
    private String byteInfo;

}