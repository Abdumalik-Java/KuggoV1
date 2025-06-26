package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.AddressDto;
import abdumalik.dev.kugoo.model.Address;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    AddressRepo repo;

    public List<Address> getAll() {
        return repo.findAll();
    }

    public Address getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(AddressDto dto) {
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setRegion(dto.getRegion());
        address.setStreet(dto.getStreet());
        address.setHomeNumber(dto.getHomeNumber());
        repo.save(address);
        return new Result("Address info created successfully", true);
    }

    public Result update(UUID id, AddressDto dto) {
        Optional<Address> byId = repo.findById(id);
        if (byId.isPresent()) {
            Address address = byId.get();
            address.setCity(dto.getCity());
            address.setRegion(dto.getRegion());
            address.setStreet(dto.getStreet());
            address.setHomeNumber(dto.getHomeNumber());
            repo.save(address);
            return new Result("Address info updated successfully", true);
        }
        return new Result("Address info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Address> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Address info deleted successfully", true);
        }
        return new Result("Address info not found", false);
    }

}