package abdumalik.dev.kugoo.repository;

import abdumalik.dev.kugoo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, UUID> {
}