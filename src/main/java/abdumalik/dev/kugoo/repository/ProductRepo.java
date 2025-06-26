package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, UUID> {
    Optional<Product> findByName(String name);
}