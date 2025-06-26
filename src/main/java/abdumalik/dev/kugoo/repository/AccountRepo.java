package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Account;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepo extends JpaRepository<Account, UUID> {
    boolean existsByEmail(@Email String email);
    Optional<Account> findByEmail(@Email String email);
}
