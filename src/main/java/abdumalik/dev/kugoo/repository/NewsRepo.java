package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NewsRepo extends JpaRepository<News, UUID> {
    Optional<News> findByTitle(String title);
}