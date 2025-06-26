package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.MainServiceDto;
import abdumalik.dev.kugoo.model.*;
import abdumalik.dev.kugoo.repository.ContactRepo;
import abdumalik.dev.kugoo.repository.MainServiceRepo;
import abdumalik.dev.kugoo.repository.PhotoRepo;
import abdumalik.dev.kugoo.repository.ReelsMediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MainServiceService {

    @Autowired
    MainServiceRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    ReelsMediaRepo reelsMediaRepo;

    @Autowired
    ContactRepo contactRepo;

    public List<MainService> findAll() {
        return repo.findAll();
    }

    public MainService findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(MainServiceDto dto) {
        MainService mainService = new MainService();

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        mainService.setPhotoId(photo);

        Optional<ReelsMedia> byId1 = reelsMediaRepo.findById(dto.getReelsMediaId());
        ReelsMedia reelsMedia = byId1.get();
        mainService.setReelsMediaId(reelsMedia);

        mainService.setQuestion(dto.getQuestion());

        Optional<Contact> byId2 = contactRepo.findById(dto.getContact());
        Contact contact = byId2.get();
        mainService.setContact(contact);

        repo.save(mainService);
        return new Result("Main Service added successfully", true);
    }

    public Result update(UUID id, MainServiceDto dto) {
        Optional<MainService> byId = repo.findById(id);
        if(byId.isPresent()) {
            MainService mainService = byId.get();

            Optional<Photo> byId1 = photoRepo.findById(dto.getPhotoId());
            Photo photo = byId1.get();
            mainService.setPhotoId(photo);

            Optional<ReelsMedia> byId2 = reelsMediaRepo.findById(dto.getReelsMediaId());
            ReelsMedia reelsMedia = byId2.get();
            mainService.setReelsMediaId(reelsMedia);

            mainService.setQuestion(dto.getQuestion());

            Optional<Contact> byId3 = contactRepo.findById(dto.getContact());
            Contact contact = byId3.get();
            mainService.setContact(contact);

            repo.save(mainService);
            return new Result("Main Service updated successfully", true);
        }
        return new Result("Main Service not found", false);
    }

    public Result delete(UUID id) {
        Optional<MainService> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Main Service deleted successfully", true);
        }
        return new Result("Main Service not found", false);
    }

}