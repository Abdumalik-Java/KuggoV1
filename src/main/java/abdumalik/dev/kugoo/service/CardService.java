package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.CardDto;
import abdumalik.dev.kugoo.model.Card;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    CardRepo repo;

    public List<Card> getAllCards() {
        return repo.findAll();
    }

    public Card getCardById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(CardDto dto) {
        Card card = new Card();
        card.setCardNumber(dto.getCardNumber());
        card.setCvNumber(dto.getCvNumber());
        repo.save(card);
        return new Result("Card info created successfully", true);
    }

    public Result update(UUID id, CardDto dto) {
        Optional<Card> byId = repo.findById(id);
        if (byId.isPresent()) {
            Card card = byId.get();
            card.setCardNumber(dto.getCardNumber());
            card.setCvNumber(dto.getCvNumber());
            repo.save(card);
            return new Result("Card info updated successfully", true);
        }
        return new Result("Card info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Card> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Card info deleted successfully", true);
        }
        return new Result("Card info not found", false);
    }

}