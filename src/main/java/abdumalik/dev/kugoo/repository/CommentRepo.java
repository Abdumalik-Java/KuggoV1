package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {
}