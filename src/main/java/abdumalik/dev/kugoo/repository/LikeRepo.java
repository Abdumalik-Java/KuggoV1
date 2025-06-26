package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LikeRepo extends JpaRepository<Like, UUID> {
    Optional<Like> findByLikeCount(Integer likeCount);
}