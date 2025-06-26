package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.ProductDto;
import abdumalik.dev.kugoo.model.*;
import abdumalik.dev.kugoo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    LikeRepo likeRepo;

    @Autowired
    CardRepo cardRepo;

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Product> findByName(String name) {
        return repo.findByName(name);
    }

    public Result create(ProductDto dto) {
        Product product = new Product();

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        product.setPhotoId(photo);

        product.setName(dto.getName());
        product.setPower(dto.getPower());
        product.setSpeed(dto.getSpeed());
        product.setHour(dto.getHour());
        product.setPrice(dto.getPrice());

        Optional<Cart> byId1 = cartRepo.findById(dto.getCartId());
        Cart cart = byId1.get();
        product.setCart(cart);

        Optional<Like> byId2 = likeRepo.findById(dto.getLikeId());
        Like like = byId2.get();
        product.setLike(like);

        Optional<Card> byId3 = cardRepo.findById(dto.getCardId());
        Card card = byId3.get();
        product.setCard(card);

        repo.save(product);
        return new Result("Product info created successfully", true);
    }

    public Result update(UUID id, ProductDto dto) {
        Optional<Product> byId = repo.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();

            Optional<Photo> byPhoto = photoRepo.findById(dto.getPhotoId());
            Photo photo = byPhoto.get();
            product.setPhotoId(photo);

            product.setName(dto.getName());
            product.setPower(dto.getPower());
            product.setSpeed(dto.getSpeed());
            product.setHour(dto.getHour());
            product.setPrice(dto.getPrice());

            Optional<Cart> byId1 = cartRepo.findById(dto.getCartId());
            Cart cart = byId1.get();
            product.setCart(cart);

            Optional<Like> byId2 = likeRepo.findById(dto.getLikeId());
            Like like = byId2.get();
            product.setLike(like);

            Optional<Card> byId3 = cardRepo.findById(dto.getCardId());
            Card card = byId3.get();
            product.setCard(card);

            repo.save(product);
            return new Result("Product info updated successfully", true);
        }
        return new Result("Product info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Product> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Product info deleted successfully", true);
        }
        return new Result("Product info not found", false);
    }

}