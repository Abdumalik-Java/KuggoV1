package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.ReelsMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReelsMediaRepo extends JpaRepository<ReelsMedia, UUID> {
}