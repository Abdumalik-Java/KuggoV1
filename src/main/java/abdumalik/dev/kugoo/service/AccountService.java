package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.AccountDto;
import abdumalik.dev.kugoo.model.Account;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.AccountRepo;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    AccountRepo repo;

    public List<Account> getAll() {
        return repo.findAll();
    }

    public Account getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Account> getByEmail(@Email String email) {
        return repo.findByEmail(email);
    }

    public Result create(AccountDto dto) {
        boolean b = repo.existsByEmail(dto.getEmail());
        if (b) {
            return new Result("Email is already exists", false);
        }
        Account account = new Account();
        account.setFirstName(dto.getFirstName());
        account.setLastName(dto.getLastName());
        account.setBirthDate(dto.getBirthDate());
        account.setEmail(dto.getEmail());
        account.setPassword(dto.getPassword());
        account.setPhoneNumber(dto.getPhoneNumber());
        account.setStatus(dto.getStatus());
        repo.save(account);
        return new Result("Account created successfully", true);
    }

    public Result update(UUID id, AccountDto dto) {
        Optional<Account> byId = repo.findById(id);
        if (byId.isPresent()) {
            Account account = byId.get();
            account.setFirstName(dto.getFirstName());
            account.setLastName(dto.getLastName());
            account.setBirthDate(dto.getBirthDate());
            account.setEmail(dto.getEmail());
            account.setPassword(dto.getPassword());
            account.setPhoneNumber(dto.getPhoneNumber());
            account.setStatus(dto.getStatus());
            repo.save(account);
            return new Result("Account updated successfully", true);
        }
        return new Result("Account not found", false);
    }

    public Result delete(UUID id) {
        Optional<Account> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Account deleted successfully", true);
        }
        return new Result("Account not found", false);
    }

}