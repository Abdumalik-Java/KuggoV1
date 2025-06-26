package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepo extends JpaRepository<Card, UUID> {
}