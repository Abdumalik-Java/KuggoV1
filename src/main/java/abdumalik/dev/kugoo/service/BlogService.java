package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.BlogDto;
import abdumalik.dev.kugoo.model.*;
import abdumalik.dev.kugoo.repository.BlogRepo;
import abdumalik.dev.kugoo.repository.CommentRepo;
import abdumalik.dev.kugoo.repository.PhotoRepo;
import abdumalik.dev.kugoo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogService {

    @Autowired
    BlogRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CommentRepo commentRepo;

    public List<Blog> findAll() {
        return repo.findAll();
    }

    public Blog findById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Blog> findByTitle(String title) {
        return repo.findByTitle(title);
    }

    public Result create(BlogDto dto) {
        Blog blog = new Blog();

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        blog.setPhotoId(photo);

        Optional<Product> byId1 = productRepo.findById(dto.getProductId());
        Product product = byId1.get();
        blog.setProductId(product);

        blog.setTitle(dto.getTitle());

        Optional<Comment> byId2 = commentRepo.findById(dto.getCommentId());
        Comment comment = byId2.get();
        blog.setCommentId(comment);

        blog.setViewCount(dto.getViewCount());

        repo.save(blog);
        return new Result("Blog info created successfully", true);
    }

    public Result update(UUID id, BlogDto dto) {
        Optional<Blog> byId = repo.findById(id);
        if (byId.isPresent()) {
            Blog blog = byId.get();

            Optional<Photo> byId1 = photoRepo.findById(dto.getPhotoId());
            Photo photo = byId1.get();
            blog.setPhotoId(photo);

            Optional<Product> byId2 = productRepo.findById(dto.getProductId());
            Product product = byId2.get();
            blog.setProductId(product);

            blog.setTitle(dto.getTitle());

            Optional<Comment> byId3 = commentRepo.findById(dto.getCommentId());
            Comment comment = byId3.get();
            blog.setCommentId(comment);

            blog.setViewCount(dto.getViewCount());

            repo.save(blog);
            return new Result("Blog info updated successfully", true);
        }
        return new Result("Blog info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Blog> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Blog info deleted successfully", true);
        }
        return new Result("Blog info not found", false);
    }

}