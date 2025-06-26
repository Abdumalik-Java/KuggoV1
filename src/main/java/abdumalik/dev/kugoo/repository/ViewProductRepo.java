package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.ViewProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ViewProductRepo extends JpaRepository<ViewProduct, UUID> {
    Optional<ViewProduct> findByCountViewIs(Integer countView);
}