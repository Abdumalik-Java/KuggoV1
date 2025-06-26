package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BlogRepo extends JpaRepository<Blog, UUID> {
    Optional<Blog> findByTitle(String title);
}