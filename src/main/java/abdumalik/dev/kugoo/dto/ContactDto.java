package abdumalik.dev.kugoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private UUID addressId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String phoneNumber;
    private String title;

}