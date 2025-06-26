package abdumalik.dev.kugoo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReelsMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Account> accountId;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Photo> photoId;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Comment> commentId;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}