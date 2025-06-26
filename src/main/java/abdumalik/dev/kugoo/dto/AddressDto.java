package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String city;
    private String region;
    private String street;
    private String homeNumber;

}