package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.DiscountsDto;
import abdumalik.dev.kugoo.model.Discounts;
import abdumalik.dev.kugoo.model.Photo;
import abdumalik.dev.kugoo.model.Product;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.DiscountsRepo;
import abdumalik.dev.kugoo.repository.PhotoRepo;
import abdumalik.dev.kugoo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiscountsService {

    @Autowired
    DiscountsRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    ProductRepo productRepo;

    public List<Discounts> findAll() {
        return repo.findAll();
    }

    public Discounts findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(DiscountsDto dto) {
        Discounts discounts = new Discounts();

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        discounts.setPhotoId((List<Photo>) photo);

        discounts.setTitle(dto.getTitle());

        Optional<Product> byId1 = productRepo.findById(dto.getProductId());
        Product product = byId1.get();
        discounts.setProductId(product);

        discounts.setFromDate(dto.getFromDate());
        discounts.setToDate(dto.getToDate());

        repo.save(discounts);
        return new Result("Discount info created successfully", true);
    }

    public Result update(UUID id, DiscountsDto dto) {
        Optional<Discounts> byId = repo.findById(id);
        if (byId.isPresent()) {
            Discounts discounts = byId.get();

            Optional<Photo> byId1 = photoRepo.findById(dto.getPhotoId());
            Photo photo = byId1.get();
            discounts.setPhotoId((List<Photo>) photo);

            discounts.setTitle(dto.getTitle());

            Optional<Product> byId2 = productRepo.findById(dto.getProductId());
            Product product = byId2.get();
            discounts.setProductId(product);

            discounts.setFromDate(dto.getFromDate());
            discounts.setToDate(dto.getToDate());

            repo.save(discounts);
            return new Result("Discount info updated successfully", true);
        }
        return new Result("Discount info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Discounts> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Discount info deleted successfully", true);
        }
        return new Result("Discount info not found", false);
    }

}