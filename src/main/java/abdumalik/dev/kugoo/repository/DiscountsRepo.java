package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscountsRepo extends JpaRepository<Discounts, UUID> {
}