package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PhotoRepo extends JpaRepository<Photo, UUID> {
    Optional<Photo> findByName(String name);
}