package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address, UUID> {
}