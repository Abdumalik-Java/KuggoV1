package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepo extends JpaRepository<Cart, UUID> {
}