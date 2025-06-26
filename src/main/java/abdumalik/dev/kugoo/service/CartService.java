package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.CartDto;
import abdumalik.dev.kugoo.model.Card;
import abdumalik.dev.kugoo.model.Cart;
import abdumalik.dev.kugoo.model.Photo;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.CardRepo;
import abdumalik.dev.kugoo.repository.CartRepo;
import abdumalik.dev.kugoo.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    CartRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    CardRepo cardRepo;

    public List<Cart> getAll() {
        return repo.findAll();
    }

    public Cart getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(CartDto dto) {
        Cart cart = new Cart();

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        cart.setPhotoId(photo);

        cart.setCount(dto.getCount());
        cart.setTotalSum(dto.getTotalSum());

        Optional<Card> byId1 = cardRepo.findById(dto.getCardId());
        Card card = byId1.get();
        cart.setCardId((List<Card>) card);

        repo.save(cart);
        return new Result("Cart info created successfully", true);
    }

    public Result update(UUID id, CartDto dto) {
        Optional<Cart> byId = repo.findById(id);
        if (byId.isPresent()) {
            Cart cart = byId.get();

            Optional<Photo> byId1 = photoRepo.findById(dto.getPhotoId());
            Photo photo = byId1.get();
            cart.setPhotoId(photo);

            cart.setCount(dto.getCount());
            cart.setTotalSum(dto.getTotalSum());

            Optional<Card> byId2 = cardRepo.findById(dto.getCardId());
            Card card = byId2.get();
            cart.setCardId((List<Card>) card);

            repo.save(cart);
            return new Result("Cart info updated successfully", true);
        }
        return new Result("Cart info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Cart> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Cart info deleted successfully", true);
        }
        return new Result("Cart info not found", false);
    }

}