package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.MainService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MainServiceRepo extends JpaRepository<MainService, UUID> {
}