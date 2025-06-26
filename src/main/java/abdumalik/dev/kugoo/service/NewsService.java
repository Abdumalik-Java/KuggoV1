package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.NewsDto;
import abdumalik.dev.kugoo.model.Contact;
import abdumalik.dev.kugoo.model.News;
import abdumalik.dev.kugoo.model.Photo;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.ContactRepo;
import abdumalik.dev.kugoo.repository.NewsRepo;
import abdumalik.dev.kugoo.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NewsService {

    @Autowired
    NewsRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    ContactRepo contactRepo;

    public List<News> getNews() {
        return repo.findAll();
    }

    public News getNewsById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<News> getByTitle(String title) {
        return repo.findByTitle(title);
    }

    public Result create(NewsDto dto) {
        News news = new News();

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        news.setPhotoId((List<Photo>) photo);

        news.setTitle(dto.getTitle());
        news.setLinks(dto.getLinks());

        Optional<Contact> byId1 = contactRepo.findById(dto.getContactId());
        Contact contact = byId1.get();
        news.setContact(contact);

        repo.save(news);
        return new Result("News info created successfully", true);
    }

    public Result update(UUID id, NewsDto dto) {
        Optional<News> byId = repo.findById(id);
        if (byId.isPresent()) {
            News news = byId.get();

            Optional<Photo> byId1 = photoRepo.findById(dto.getPhotoId());
            Photo photo = byId1.get();
            news.setPhotoId((List<Photo>) photo);

            news.setTitle(dto.getTitle());
            news.setLinks(dto.getLinks());

            Optional<Contact> byId2 = contactRepo.findById(dto.getContactId());
            Contact contact = byId2.get();
            news.setContact(contact);

            repo.save(news);
            return new Result("News info updated successfully", true);
        }
        return new Result("News info not found", false);
    }

    public Result delete(UUID id) {
        Optional<News> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("News deleted successfully", true);
        }
        return new Result("News info not found", false);
    }

}