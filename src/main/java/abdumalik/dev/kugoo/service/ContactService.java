package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.ContactDto;
import abdumalik.dev.kugoo.model.Address;
import abdumalik.dev.kugoo.model.Contact;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.AddressRepo;
import abdumalik.dev.kugoo.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    ContactRepo repo;

    @Autowired
    AddressRepo addressRepo;

    public List<Contact> findAll() {
        return repo.findAll();
    }

    public Contact findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(ContactDto dto) {
        Contact contact = new Contact();

        Optional<Address> byId = addressRepo.findById(dto.getAddressId());
        Address address = byId.get();
        contact.setAddressId(address);

        contact.setFromDate(dto.getFromDate());
        contact.setToDate(dto.getToDate());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setTitle(dto.getTitle());

        repo.save(contact);
        return new Result("Contact info created successfully", true);
    }

    public Result update(UUID id, ContactDto dto) {
        Optional<Contact> byId = repo.findById(id);
        if (byId.isPresent()) {
            Contact contact = byId.get();

            Optional<Address> byAddressId = addressRepo.findById(dto.getAddressId());
            Address address = byAddressId.get();
            contact.setAddressId(address);

            contact.setFromDate(dto.getFromDate());
            contact.setToDate(dto.getToDate());
            contact.setPhoneNumber(dto.getPhoneNumber());
            contact.setTitle(dto.getTitle());

            repo.save(contact);
            return new Result("Contact info updated successfully", true);
        }
        return new Result("Contact info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Contact> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Contact info deleted successfully", true);
        }
        return new Result("Contact info not found", false);
    }

}